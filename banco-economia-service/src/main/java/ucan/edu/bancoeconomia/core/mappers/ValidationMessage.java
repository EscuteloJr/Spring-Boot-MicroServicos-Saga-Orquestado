package ucan.edu.bancoeconomia.core.mappers;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ValidationMessage {
    final private String message;
    final private boolean isValid;
}
