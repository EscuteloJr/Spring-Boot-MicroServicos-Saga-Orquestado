/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ucan.sdp2.bancodireito.direito.core.dto;

import edu.ucan.sdp2.bancodireito.direito.core.enums.ESagaStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 *
 * @author escutelo
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Historico {
    
    private String source;
    ESagaStatus status;
    String message;
    private LocalDateTime createdAt;
    
}
