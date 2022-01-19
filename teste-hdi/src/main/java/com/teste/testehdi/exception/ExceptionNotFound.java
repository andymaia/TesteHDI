package com.teste.testehdi.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionNotFound extends ResponseEntityExceptionHandler{

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleAnyException(Exception e, WebRequest request){
        String description = e.getLocalizedMessage() != null ?e.getLocalizedMessage() : e.toString();
        ErrorsMessage errorsMessage = new ErrorsMessage(new Date(), description);
        return new ResponseEntity<>(errorsMessage,new HttpHeaders(),HttpStatus.NOT_FOUND);
    }

}