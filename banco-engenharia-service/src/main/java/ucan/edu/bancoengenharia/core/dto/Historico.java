/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucan.edu.bancoengenharia.core.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ucan.edu.bancoengenharia.core.enums.ESagaStatus;

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
