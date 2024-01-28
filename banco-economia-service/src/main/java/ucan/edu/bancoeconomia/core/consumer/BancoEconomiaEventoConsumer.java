/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucan.edu.bancoeconomia.core.consumer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ucan.edu.bancoeconomia.core.dto.Evento;
import ucan.edu.bancoeconomia.core.utils.JsonUtil;

/**
 *
 * @author escutelo
 */
@Slf4j
@Component
@AllArgsConstructor
public class BancoEconomiaEventoConsumer {

    private static final String TRANSFERENCIA_SUCESS = "transferencia-success";
    private static final String TRANSFERENCIA_FAIL = "transferencia-fail";
    private static final String MOVIMENTOS_CONTA_SUCCESS = "movimentos-success";
    private static final String MOVIMENTOS_CONTA_FAIL = "movimentos-fail";
    private static final String PAGAMENTO_SUCCESS = "pagamento-success";
    private static final String PAGAMENTO_FAIL = "pagamento-fail";

    private final JsonUtil jsonUtil;

    @KafkaListener(
            groupId = "${spring.kafka.consumer.group-id}",
            topics = TRANSFERENCIA_SUCESS
    )
    public void consumerTransferenciaSucessEvent(String transacao) {
        log.info("Recebendo evento {} do topico TRANSFERENCIA_SUCESS", transacao);
        Evento evento = jsonUtil.toEvento(transacao);
        log.info(evento.toString());
    }

    @KafkaListener(
            groupId = "${spring.kafka.consumer.group-id}",
            topics = TRANSFERENCIA_FAIL
    )
    public void consumerTransferenciaFailEvent(String transacao) {
        log.info("Recebendo evento {} do topico TRANSFERENCIA_FAIL", transacao);
        Evento evento = jsonUtil.toEvento(transacao);
        log.info(evento.toString());
    }

    @KafkaListener(
            groupId = "${spring.kafka.consumer.group-id}",
            topics = MOVIMENTOS_CONTA_SUCCESS
    )
    public void consumerMovimentosContaSucessEvent(String transacao) {
        log.info("Recebendo evento {} do topico MOVIMENTOS_CONTA_SUCCESS", transacao);
        Evento evento = jsonUtil.toEvento(transacao);
        log.info(evento.toString());
    }

    @KafkaListener(
            groupId = "${spring.kafka.consumer.group-id}",
            topics = MOVIMENTOS_CONTA_FAIL
    )
    public void consumerMovimentosContaFailEvent(String transacao) {
        log.info("Recebendo evento {} do topico MOVIMENTOS_CONTA_FAIL", transacao);
        Evento evento = jsonUtil.toEvento(transacao);
        log.info(evento.toString());
    }

    @KafkaListener(
            groupId = "${spring.kafka.consumer.group-id}",
            topics = PAGAMENTO_SUCCESS
    )
    public void consumerPagamentoSucessEvent(String transacao) {
        log.info("Recebendo evento {} do topico PAGAMENTO_SUCCESS", transacao);
        Evento evento = jsonUtil.toEvento(transacao);
        log.info(evento.toString());
    }

    @KafkaListener(
            groupId = "${spring.kafka.consumer.group-id}",
            topics = PAGAMENTO_FAIL
    )
    public void consumerPagamentoFailEvent(String transacao) {
        log.info("Recebendo evento {} do topico PAGAMENTO_FAIL", transacao);
        Evento evento = jsonUtil.toEvento(transacao);
        log.info(evento.toString());
    }
}
