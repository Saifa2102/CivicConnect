package com.example.CivicConnect.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> apiErrorResponseEntity(ResourceNotFoundException e)
    {
       ApiError apiError= ApiError.builder()
               .localDateTime(LocalDateTime.now())
               .httpStatus(HttpStatus.NOT_FOUND)
               .message(e.getMessage())
               .build();

       return new ResponseEntity<>(apiError,HttpStatus.NOT_FOUND);
    }
}
