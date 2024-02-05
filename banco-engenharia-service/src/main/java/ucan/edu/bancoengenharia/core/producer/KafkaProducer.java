/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucan.edu.bancoengenharia.core.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import ucan.edu.bancoengenharia.core.dto.Evento;
import ucan.edu.bancoengenharia.core.enums.ETopicos;
import static ucan.edu.bancoengenharia.core.enums.ETopicos.CONECTA;
import ucan.edu.bancoengenharia.core.utils.JsonUtil;

/**
 *
 * @author escutelo
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final JsonUtil util;

    public void enviarEvento(String transacao) {
        try {
            log.info("Enviando dados ao topico {} com dados {}", CONECTA.getTopico(), transacao);
            Evento evento = util.toEvento(transacao);
            log.info("Topico a receber {}", evento);
            kafkaTemplate.send(CONECTA.getTopico(), util.toJson(evento));
        } catch (Exception e) {
            log.error("Erro ao enviar dados ao topico {} com dados {}", CONECTA.getTopico(), transacao, e);
        }
    }
}
