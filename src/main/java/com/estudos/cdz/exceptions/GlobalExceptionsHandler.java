package com.estudos.cdz.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionsHandler {

    @ExceptionHandler(KnightException.class)
    public ResponseEntity<ErrorObject> handlerKnightNotFoundException(KnightException ex, WebRequest request){
        ErrorObject error = new ErrorObject();
        error.setStatusCode(HttpStatus.NOT_FOUND.value());
        error.setMessage(ex.getMessage());
        error.setTimeStamp(new Date());

        return new ResponseEntity<ErrorObject>(error, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(ArmorException.class)
    public ResponseEntity<ErrorObject> handlerArmorNotFoundException(ArmorException ex, WebRequest request){
        ErrorObject error = new ErrorObject();
        error.setStatusCode(HttpStatus.NOT_FOUND.value());
        error.setMessage(ex.getMessage());
        error.setTimeStamp(new Date());

        return new ResponseEntity<ErrorObject>(error, HttpStatus.NOT_FOUND);
    }
    
}
