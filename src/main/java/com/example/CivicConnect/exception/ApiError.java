package com.example.CivicConnect.exception;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;
@Data
@Builder
public class ApiError {
    private LocalDateTime localDateTime;
    private HttpStatus httpStatus;
    private String message;
    private List<String> suberror;
}
