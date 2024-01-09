/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucan.edu.conecta.config.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author escutelo
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ExceptionValidation extends RuntimeException {

    public ExceptionValidation(String message) {
        super(message);
    }

}
