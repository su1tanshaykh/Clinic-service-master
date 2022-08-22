package com.example.exam.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<?> handler(BadRequest badRequest){
        return ResponseEntity.badRequest().body(badRequest.getMessage());
    }
}
