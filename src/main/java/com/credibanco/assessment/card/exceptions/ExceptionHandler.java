package com.credibanco.assessment.card.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = {Exception.class})
    protected ResponseEntity<ResponseException> handleConflict(Exception e) {
        System.out.println("encontro al manejador global de excepciones");
        ResponseException resposnseException = new ResponseException("error inesperado : " + e.getMessage());
        return new ResponseEntity<>(resposnseException, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = {MethodArgumentNotValidException.class})
    protected ResponseEntity<ResponseException> handleConflict(MethodArgumentNotValidException e) {
        System.out.println("encontro al manejador MethodArgumentNotValidException de excepciones");
        ResponseException resposnseException = new ResponseException("BAD_REQUEST  : " + e.getMessage());
        return new ResponseEntity<>(resposnseException, HttpStatus.BAD_REQUEST);
    }
}
