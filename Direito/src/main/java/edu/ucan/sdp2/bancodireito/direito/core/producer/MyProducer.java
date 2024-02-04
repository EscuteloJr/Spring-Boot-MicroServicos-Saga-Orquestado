/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ucan.sdp2.bancodireito.direito.core.producer;

import edu.ucan.sdp2.bancodireito.direito.core.models.DataTeste;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.requestreply.ReplyingKafkaTemplate;
import org.springframework.stereotype.Component;

import static edu.ucan.sdp2.bancodireito.direito.core.enums.ETopicos.CONECTA;
import static edu.ucan.sdp2.bancodireito.direito.core.enums.ETopicos.TRANSFERENCIA_SUCESS;


/**
 *
 * @author escutelo
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class MyProducer {

    private final ;

    public void enviarEvento(DataTeste transacao) {
        try {
            KafkaTemplate<String, DataTeste> kafkaTemplate = new ReplyingKafkaTemplate<>();
            log.info("Enviando dados ao topico {} com dados {}", TRANSFERENCIA_SUCESS.getTopico(), transacao);
            kafkaTemplate.send(CONECTA.getTopico(), transacao);
        } catch (Exception e) {
            log.error("Erro ao enviar dados ao topico {} com dados {}", CONECTA.getTopico(), transacao, e);
        }
    }
}
