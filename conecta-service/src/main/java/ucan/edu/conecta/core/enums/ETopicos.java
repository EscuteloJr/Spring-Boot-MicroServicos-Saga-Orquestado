/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package ucan.edu.conecta.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *
 * @author escutelo
 */
@Getter
@AllArgsConstructor
public enum ETopicos {

    START_SAGA("start-saga"),
    BASE_ORQUESTRADOR("orquestrador"),
    FINISH_SUCCESS("finish_success"),
    FINISH_FAIL("finish_fail"),
    MOVIMENTOS_SUCCESS("movimentos-success"),
    MOVIMENTOS_FAIL("movimentos-fail"),
    PAGAMENTO_SUCCESS("pagamento-success"),
    PAGAMENTO_FAIL("pagamento-fail"),
    BANCO_ENGENHARIA_RECIEVER("banco-engenharia-receiver");

    //OTHERS TOPICS HERE
    private final String topico;
}
