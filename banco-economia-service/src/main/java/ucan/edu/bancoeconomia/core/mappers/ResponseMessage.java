package ucan.edu.bancoeconomia.core.mappers;

import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
public class ResponseMessage<T> {
    final private T data;
    final private String message;
    final private Integer status;
    final private LocalDateTime timestamp = LocalDateTime.now();
}
