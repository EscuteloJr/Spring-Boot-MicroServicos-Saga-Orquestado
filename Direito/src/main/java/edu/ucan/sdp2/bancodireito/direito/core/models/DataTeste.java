package edu.ucan.sdp2.bancodireito.direito.core.models;


import lombok.Builder;
import lombok.Data;
import lombok.With;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.List;

@Data
@Builder
@With
public class DataTeste implements Serializable {
        private String id;
        private String transactionID;
        private Detalhes detalhes;
        private String transacaoTipo;
        private String source;
        private String status;
        private List<EventHistory> eventHistory;
        private OffsetDateTime createdAt;
    }