package com.jduk.api.exception;

import org.hibernate.PropertyValueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<Object> manageItemNotFoundException(NoResultFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<Object> managePropertyValueException(PropertyValueException e) {
        String message = "Bad Request. Album must be assigned a name, genre, and release date, alongside an " +
                "indication of whether it is age restricted, and the corresponding entries of type Artist and Stock.";
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }
}
