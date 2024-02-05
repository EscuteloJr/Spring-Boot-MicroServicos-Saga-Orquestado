/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucan.edu.bancoengenharia.core.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ucan.edu.bancoengenharia.core.enums.ESagaStatus;
import ucan.edu.bancoengenharia.core.enums.ETransacaoTipo;

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

    public void addToHistorico(Historico historico) {
        if (historicoDeEvento == null) {
            historicoDeEvento = new ArrayList<>();
        }
        if (historicoDeEvento.isEmpty()) {
            historicoDeEvento = new ArrayList<>();
        }
        historicoDeEvento.add(historico);
    }
}
