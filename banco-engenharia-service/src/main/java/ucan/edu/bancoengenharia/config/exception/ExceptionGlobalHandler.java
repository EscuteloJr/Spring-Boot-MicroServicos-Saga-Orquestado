/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucan.edu.bancoengenharia.config.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author escutelo
 */
@ControllerAdvice
public class ExceptionGlobalHandler {

    @ExceptionHandler(ExceptionValidation.class)
    public ResponseEntity<?> handlerValidationException(ExceptionValidation ev) {
        var details = new ExceptionDetails(HttpStatus.BAD_REQUEST.value(), ev.getMessage());
        return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
    }
}
