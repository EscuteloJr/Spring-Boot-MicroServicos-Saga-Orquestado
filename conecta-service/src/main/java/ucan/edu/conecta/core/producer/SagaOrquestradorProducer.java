/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucan.edu.conecta.core.producer;

import static java.lang.Math.log;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 *
 * @author escutelo
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class SagaOrquestradorProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void enviarEvento(String transacao, String topico) {
        try {
            log.info("Enviando dados ao topico {} com dados {}", topico, transacao);
            //kafkaTemplate.send(topico, transacao);
            kafkaTemplate.send(topico, transacao);
        } catch (Exception e) {
            log.error("Erro ao enviar dados ao topico {} com dados {}", topico, transacao, e);
        }
    }
}
