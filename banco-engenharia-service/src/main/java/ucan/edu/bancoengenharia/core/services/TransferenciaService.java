/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucan.edu.bancoengenharia.core.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.security.oauthbearer.internals.secured.ValidateException;
import org.springframework.stereotype.Service;
import ucan.edu.bancoengenharia.core.dto.Evento;
import ucan.edu.bancoengenharia.core.dto.Historico;
import ucan.edu.bancoengenharia.core.dto.TranferenciaDetalhes;

import ucan.edu.bancoengenharia.core.enums.EEstadoTipo;
import ucan.edu.bancoengenharia.core.enums.ESagaStatus;
import ucan.edu.bancoengenharia.core.model.Conta;
import ucan.edu.bancoengenharia.core.model.Transacao;
import ucan.edu.bancoengenharia.core.producer.KafkaProducer;
import ucan.edu.bancoengenharia.core.repositories.ContaRepository;
import ucan.edu.bancoengenharia.core.repositories.TransacaoRepository;
import ucan.edu.bancoengenharia.core.utils.JsonUtil;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;
import static ucan.edu.bancoengenharia.core.enums.ESagaStatus.ROLLBACK_PENDING;
import static ucan.edu.bancoengenharia.core.enums.ETransacaoTipo.TRANSFERENCIA;

/**
 *
 * @author escutelo
 */
@Slf4j
@Service
@AllArgsConstructor
public class TransferenciaService {

    private static final String CURRENT_SOURCE = "BANCO_ENGENHARIA_SERVICE";

    private final JsonUtil jsonUtil;
    private final KafkaProducer producer;
    private final TransacaoRepository repository;
    private final ContaRepository contaRepository;

    public void transferenciaReciever(Evento evento) {
        try {

            verificarTransacao(evento);
            criarTransacao(evento);
            TranferenciaDetalhes detalhes = (TranferenciaDetalhes) evento.getDetalhes();
            Transacao transacao = repository.findByIdAndContaId(UUID.fromString(evento.getTransactionId()), UUID.fromString(detalhes.getContaOrigem()))
                    .orElseThrow(() -> new ValidateException("Transacao nao encontrada"));
            alterarTransacaoSuccess(transacao);
            handleStatusSucsess(evento);
        } catch (Exception e) {
            log.error("Erro ao tentar realizar a transacao", e);
            handleFailCurrentNotExecuted(evento, e.getMessage());
        }
         producer.enviarEvento(jsonUtil.toJson(evento));
    }

    private void handleFailCurrentNotExecuted(Evento evento, String message) {
        evento.setStatus(ROLLBACK_PENDING);
        evento.setSource(CURRENT_SOURCE);
        addToHistorico(evento, "Falha ao realizar transacao : ".concat(message));
    }

    private void verificarTransacao(Evento evento) {
        if (evento.getTransacaoTipo().equals(TRANSFERENCIA)) {
            TranferenciaDetalhes detalhes =  (TranferenciaDetalhes) evento.getDetalhes();
            if (repository.existsByIdAndContaId(UUID.fromString(evento.getTransactionId()), UUID.fromString(detalhes.getContaOrigem()))) {
                throw new ValidateException("Transacao existente");
            }
        }

    }

    private void criarTransacao(Evento evento) {
        if (evento.getTransacaoTipo().equals(TRANSFERENCIA)) {
            TranferenciaDetalhes detalhes = (TranferenciaDetalhes) evento.getDetalhes();
            Conta conta = contaRepository.findContaById(UUID.fromString(detalhes.getContaOrigem()))
                    .orElseThrow(() -> new ValidateException("Conta Não encontrada"));
            Transacao transacao = Transacao
                    .builder()                    
                    .montante(evento.getDetalhes().getMontante())
                    .saldoAnterior(conta.getSaldo())
                    .saldoAposOMovimento(BigDecimal.valueOf((conta.getSaldo().doubleValue() - detalhes.getMontante().doubleValue())))
                    .build();
            transacao.setId(UUID.fromString(evento.getTransactionId()));
            repository.save(transacao);
        }
    }

    private Transacao findTransacaoByTransacaoIdAndContaId(Evento evento) {
        TranferenciaDetalhes detalhes = (TranferenciaDetalhes) evento.getDetalhes();
        return repository.findByIdAndContaId(UUID.fromString(evento.getTransactionId()), UUID.fromString(detalhes.getContaOrigem()))
                .orElseThrow(() -> new ValidateException("Transaco nao encontrada "));

    }

    private void alterarTransacaoSuccess(Transacao transacao) {
        transacao.setEstado(EEstadoTipo.Processado);
        repository.save(transacao);
    }

    private void handleStatusSucsess(Evento evento) {
        evento.setStatus(ESagaStatus.SUCCESS);
        evento.setSource(CURRENT_SOURCE);
        addToHistorico(evento, "Transacao feita com sucesso");
    }

    private void addToHistorico(Evento evento, String message) {
        var historico = Historico
                .builder()
                .message(message)
                .status(evento.getStatus())
                .source(evento.getSource())
                .createdAt(LocalDateTime.now())
                .build();
        evento.addToHistorico(historico);
    }

}
