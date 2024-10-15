package com.rafael.reto.microservice.account.exceptions;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.rafael.reto.microservice.account.dtos.ExceptionMessageDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlingController {

    @ExceptionHandler(JsonMappingException.class)
    public ResponseEntity<ExceptionMessageDto> handleJsonMappingException(JsonMappingException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ExceptionMessageDto.builder().message(e.getMessage()).build());
    }
}
