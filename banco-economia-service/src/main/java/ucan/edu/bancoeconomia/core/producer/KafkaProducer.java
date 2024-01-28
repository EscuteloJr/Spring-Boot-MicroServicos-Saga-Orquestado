/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucan.edu.bancoeconomia.core.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import ucan.edu.bancoeconomia.core.enums.ETopicos;
import static ucan.edu.bancoeconomia.core.enums.ETopicos.CONECTA;

/**
 *
 * @author escutelo
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void enviarEvento(String transacao) {
        try {
            log.info("Enviando dados ao topico {} com dados {}", CONECTA.getTopico(), transacao);
            kafkaTemplate.send(CONECTA.getTopico(), transacao);
        } catch (Exception e) {
            log.error("Erro ao enviar dados ao topico {} com dados {}", CONECTA.getTopico(), transacao, e);
        }
    }
}
