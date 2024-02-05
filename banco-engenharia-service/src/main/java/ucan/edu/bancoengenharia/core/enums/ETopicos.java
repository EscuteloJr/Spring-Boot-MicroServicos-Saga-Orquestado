/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package ucan.edu.bancoengenharia.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *
 * @author escutelo
 */
@Getter
@AllArgsConstructor
public enum ETopicos {

    CONECTA("orquestrador"),
    TRANSFERENCIA_SUCESS("transferencia-success"),
    TRANSFERENCIA_FAIL("transferencia-fail"),
    MOVIMENTOS_CONTA_SUCCESS("movimentos-success"),
    MOVIMENTOS_CONTA_FAIL("movimentos-fail"),
    PAGAMENTO_SUCCESS("pagamento-success"),
    PAGAMENTO_FAIL("pagamento-fail");

    //OTHERS TOPICS HERE
    private final String topico;
}
