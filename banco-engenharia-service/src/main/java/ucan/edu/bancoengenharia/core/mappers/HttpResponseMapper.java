package ucan.edu.bancoengenharia.core.mappers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class HttpResponseMapper<T> {
    T value;
    public HttpResponseMapper(T value) {
        this.value = value;
    }
    public ResponseEntity<ResponseMessage<T>> sucesso(String message) {
        return ResponseEntity.ok(new ResponseMessage<>(value, message, HttpStatus.OK.value()));
    }
    public ResponseEntity<ResponseMessage<T>> criado(String message) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseMessage<>(value, message, HttpStatus.CREATED.value()));
    }
    public ResponseEntity<ResponseMessage<T>> naoEncontrado(String message) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseMessage<>(value, message, HttpStatus.NOT_FOUND.value()));
    }
    public ResponseEntity<ResponseMessage<T>> parametrosInvalido(String message) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage<>(value, message, HttpStatus.BAD_REQUEST.value()));
    }
    public ResponseEntity<ResponseMessage<T>> erro(String message) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseMessage<>(value, message, HttpStatus.INTERNAL_SERVER_ERROR.value()));
    }
}
