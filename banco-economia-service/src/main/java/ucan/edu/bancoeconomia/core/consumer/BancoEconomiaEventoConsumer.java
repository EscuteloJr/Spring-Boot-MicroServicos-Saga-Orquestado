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
import static ucan.edu.bancoeconomia.core.enums.ETransacaoTipo.PAGAMENTO;
import static ucan.edu.bancoeconomia.core.enums.ETransacaoTipo.TRANSFERENCIA;
import ucan.edu.bancoeconomia.core.producer.KafkaProducer;
import ucan.edu.bancoeconomia.core.services.TransferenciaService;
import ucan.edu.bancoeconomia.core.utils.JsonUtil;

/**
 *
 * @author escutelo
 */
@Slf4j
@Component
@AllArgsConstructor
public class BancoEconomiaEventoConsumer {

    private static final String BANCO_ECONOMIA_SENDER = "banco-economia-sender";
    private static final String BANCO_ECONOMIA_RECIEVER = "banco-economia-receiver";
    private static final String BANCO_ECONOMIA_RECIEVER_FAIL = "banco-economia-receiver-fail";

    private final JsonUtil jsonUtil;
    private final KafkaProducer producer;
    private final TransferenciaService TransferenciaService;

    @KafkaListener(
            groupId = "${spring.kafka.consumer.group-id}",
            topics = BANCO_ECONOMIA_RECIEVER
    )
    public void consumer(String transacao) {
        log.info("Recebendo evento {} do topico BANCO_ECONOMIA_RECIEVER", transacao);
        Evento evento = jsonUtil.toEvento(transacao);
        if (evento != null) {
            if (evento.getTransacaoTipo().equals(TRANSFERENCIA)) {
                TransferenciaService.transferenciaReciever(evento);
                log.info("TRANSFERENCIA", transacao);
            } else if (evento.getTransacaoTipo().equals(PAGAMENTO)) {
                log.info("PAGAMENTO", transacao);
            }

            //producer.enviarEvento(transacao);
        }

    }

    @KafkaListener(
            groupId = "${spring.kafka.consumer.group-id}",
            topics = BANCO_ECONOMIA_RECIEVER_FAIL
    )
    public void consumerFailEvent(String transacao) {
        log.info("Recebendo evento {} do topico BANCO_ECONOMIA_RECIEVER_FAIL", transacao);
        Evento evento = jsonUtil.toEvento(transacao);
        // TransacaoService.realizarTransacao(evento);
    }
}
