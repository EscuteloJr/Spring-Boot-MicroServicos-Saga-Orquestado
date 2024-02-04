package edu.ucan.sdp2.bancodireito.direito.core.models;

import lombok.Builder;
import lombok.Data;
import lombok.With;

import java.io.Serializable;
import java.time.OffsetDateTime;

@Data
@Builder
@With
public class Detalhes implements Serializable {
    private String descricaTransacao;
    private double montante;
    private String moedaTipo;
    private OffsetDateTime dataTransacao;
    private String localDaTransacao;
    private String contaOrigem;
    private String contaDestino;
}