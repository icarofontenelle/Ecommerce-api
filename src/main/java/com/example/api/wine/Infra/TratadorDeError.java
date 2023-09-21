package com.example.api.wine.Infra;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class TratadorDeError {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity <EntityNotFoundException> tratarErro404(){
        return ResponseEntity.notFound().build();
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity <List<ErroDTO>> tratarErro400(MethodArgumentNotValidException ex){
        var erros = ex.getFieldErrors();
        
        return ResponseEntity.badRequest().body(erros.stream().map(ErroDTO::new).toList());
    }

    private record ErroDTO(String campo, String mensagem){

        public ErroDTO(FieldError erro){
            this(erro.getField(), erro.getDefaultMessage());
        }
    }

}
