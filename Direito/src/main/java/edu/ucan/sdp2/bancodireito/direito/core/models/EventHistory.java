package edu.ucan.sdp2.bancodireito.direito.core.models;

import lombok.Builder;
import lombok.Data;
import lombok.With;

import java.io.Serializable;
import java.time.OffsetDateTime;

@Data
@Builder
@With
public class EventHistory  implements Serializable {
    private String source;
    private String status;
    private String message;
    private OffsetDateTime createdAt;
}