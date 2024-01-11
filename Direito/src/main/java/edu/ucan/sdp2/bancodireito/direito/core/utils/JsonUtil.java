/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ucan.sdp2.bancodireito.direito.core.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.ucan.sdp2.bancodireito.direito.core.dto.Evento;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 *
 * @author escutelo
 */
@Component
@AllArgsConstructor
public class JsonUtil {

    private final ObjectMapper objectMapper;

    public String toJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            return "";
        }
    }

    public Evento toEvento(String json) {
        try {
            return objectMapper.readValue(json, Evento.class);
        } catch (Exception e) {
            return null;
        }
    }
}
