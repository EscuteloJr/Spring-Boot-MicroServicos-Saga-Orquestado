/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucan.edu.conecta.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author escutelo
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TranferenciaDetalhes extends TransacaoDetalhes{
    private String contaOrigem;
    private String contaDestino;
    
}
