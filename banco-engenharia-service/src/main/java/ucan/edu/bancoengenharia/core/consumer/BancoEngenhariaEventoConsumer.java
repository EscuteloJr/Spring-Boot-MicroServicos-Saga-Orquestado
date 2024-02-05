/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucan.edu.bancoengenharia.core.consumer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ucan.edu.bancoengenharia.core.dto.Evento;
import ucan.edu.bancoengenharia.core.enums.ETransacaoTipo;
import static ucan.edu.bancoengenharia.core.enums.ETransacaoTipo.PAGAMENTO;
import static ucan.edu.bancoengenharia.core.enums.ETransacaoTipo.TRANSFERENCIA;
import ucan.edu.bancoengenharia.core.producer.KafkaProducer;
import ucan.edu.bancoengenharia.core.services.TransferenciaService;
import ucan.edu.bancoengenharia.core.utils.JsonUtil;

/**
 *
 * @author escutelo
 */
@Slf4j
@Component
@AllArgsConstructor
public class BancoEngenhariaEventoConsumer {

    private static final String BANCO_ENGENHARIA_SENDER = "banco-engenharia-sender";
    private static final String BANCO_ENGENHARIA_RECIEVER = "banco-engenharia-receiver";
    private static final String BANCO_ENGENHARIA_RECIEVER_FAIL = "banco-engenharia-receiver-fail";

    private final JsonUtil jsonUtil;
    private final KafkaProducer producer;
    private final TransferenciaService TransferenciaService;

    @KafkaListener(
            groupId = "${spring.kafka.consumer.group-id}",
            topics = BANCO_ENGENHARIA_RECIEVER
    )
    public void consumer(String transacao) {
        log.info("Recebendo evento {} do topico BANCO_ENEGENHARIA_RECIEVER", transacao);
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
            topics = BANCO_ENGENHARIA_RECIEVER_FAIL
    )
    public void consumerFailEvent(String transacao) {
        log.info("Recebendo evento {} do topico BANCO_ENEGENHARIA_RECIEVER_FAIL", transacao);
        Evento evento = jsonUtil.toEvento(transacao);
        // TransacaoService.realizarTransacao(evento);
    }

}
