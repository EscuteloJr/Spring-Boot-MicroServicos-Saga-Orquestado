/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucan.edu.bancoengenharia.core.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author escutelo
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransacaoDetalhes {
    private String descricaTransacao;
    private BigDecimal montante;
    private String moedaTipo;
    private LocalDateTime dataTransacao;
    private String localDaTransacao;
    private String initiatedBy;
}
