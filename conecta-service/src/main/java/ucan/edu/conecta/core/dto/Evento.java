/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucan.edu.conecta.core.dto;

import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ucan.edu.conecta.core.enums.EEventSource;
import ucan.edu.conecta.core.enums.ESagaStatus;
import ucan.edu.conecta.core.enums.ETransacaoTipo;

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
    private EEventSource source;
    private ESagaStatus status;    
    private List<Historico> historicoDeEvento;
    private LocalDateTime createAt;
}