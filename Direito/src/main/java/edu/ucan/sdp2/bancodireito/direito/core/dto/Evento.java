/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ucan.sdp2.bancodireito.direito.core.dto;

import edu.ucan.sdp2.bancodireito.direito.core.enums.ESagaStatus;
import edu.ucan.sdp2.bancodireito.direito.core.enums.ETransacaoTipo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author escutelo
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Evento {

    private String id;
    private String transactionId;
    private TransacaoDetalhes detalhes;
    private ETransacaoTipo transacaoTipo;
    private String source;
    private ESagaStatus status;
    private List<Historico> historicoDeEvento;
    private LocalDateTime createAt;
}
