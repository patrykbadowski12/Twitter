package com.twitter.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerHandler {
    @ExceptionHandler(value = NullPointerException.class)
    public ResponseEntity<Object> exception(NullPointerException exception) {
        return new ResponseEntity<>("Null Exception.", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Object> exception(MethodArgumentNotValidException exception) {
        return new ResponseEntity<>("Parameter is too long.", HttpStatus.FORBIDDEN);
    }

}
