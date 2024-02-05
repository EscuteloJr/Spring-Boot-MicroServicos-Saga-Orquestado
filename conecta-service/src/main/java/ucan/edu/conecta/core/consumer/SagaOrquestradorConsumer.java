/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucan.edu.conecta.core.consumer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ucan.edu.conecta.core.dto.Evento;
import ucan.edu.conecta.core.enums.ETopicos;
import static ucan.edu.conecta.core.enums.ETopicos.BANCO_ENGENHARIA_RECIEVER;
import ucan.edu.conecta.core.producer.SagaOrquestradorProducer;
import ucan.edu.conecta.core.utils.JsonUtil;

/**
 *
 * @author escutelo
 */
@Slf4j
@Component
@AllArgsConstructor
public class SagaOrquestradorConsumer {

    private static final String STARTSAGA = "start-saga";
    private static final String BASEORQUESTRADOR = "orquestrador";
    private static final String FINISHSUCCESS = "finish_success";
    private static final String FINISHFAIL = "finish_fail";

    private final JsonUtil jsonUtil;
    private final SagaOrquestradorProducer orquestradorProducer;

    @KafkaListener(
            groupId = "${spring.kafka.consumer.group-id}",
            topics = STARTSAGA
    )
    public void consumerStarSagaEvent(String transacao) {

        log.info("Recebendo evento {} do topico STARTSAGA", transacao);
        Evento evento = jsonUtil.toEvento(transacao);
        System.out.println("EVENTO");
        orquestradorProducer.enviarEvento(jsonUtil.toJson(evento), BANCO_ENGENHARIA_RECIEVER.getTopico());
        log.info(evento.toString());
    }

    @KafkaListener(
            groupId = "${spring.kafka.consumer.group-id}",
            topics = BASEORQUESTRADOR
    )
    public void consumerOrquestradorEvent(String transacao) {
        log.info("Recebendo evento {} do topico BASEORQUESTRADOR", transacao);
       Evento evento = jsonUtil.toEvento(transacao);
        log.info("Evento recebido {} " ,evento);
    }

    @KafkaListener(
            groupId = "${spring.kafka.consumer.group-id}",
            topics = FINISHSUCCESS
    )
    public void consumerFinishSucessEvent(String transacao) {
        log.info("Recebendo evento {} do topico FINISHSUCCESS", transacao);
        Evento evento = jsonUtil.toEvento(transacao);
        log.info(evento.toString());
    }

    @KafkaListener(
            groupId = "${spring.kafka.consumer.group-id}",
            topics = FINISHFAIL
    )
    public void consumerFinishFailEvent(String transacao) {
        log.info("Recebendo evento {} do topico FINISHFAIL", transacao);
        Evento evento = jsonUtil.toEvento(transacao);
        log.info(evento.toString());
    }
}
