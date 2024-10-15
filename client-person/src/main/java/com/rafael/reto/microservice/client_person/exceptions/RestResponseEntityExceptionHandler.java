package com.rafael.reto.microservice.client_person.exceptions;

import com.rafael.reto.microservice.client_person.dtos.ExceptionMessageDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler {

    @ExceptionHandler(IncorrectDataException.class)
    public ResponseEntity<ExceptionMessageDto> incorrectData(final IncorrectDataException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ExceptionMessageDto.builder().message(exception.getMessage()).build());
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionMessageDto> notFound(final NotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ExceptionMessageDto.builder().message(exception.getMessage()).build());
    }
}