package com.github.springboot.controller;

import com.github.springboot.exception.CustomException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity customException(CustomException e) {
        return ResponseEntity.status(BAD_REQUEST).body(e.getMessage());
    }
}
