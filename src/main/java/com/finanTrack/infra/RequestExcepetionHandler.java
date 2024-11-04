package com.finanTrack.infra;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RequestExcepetionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity threat404(Exception ex){
        return ResponseEntity.badRequest().body("Dado não encontrado");
    }
}
