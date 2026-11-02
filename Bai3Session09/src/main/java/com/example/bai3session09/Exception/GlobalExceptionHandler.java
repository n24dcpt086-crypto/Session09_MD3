package com.example.bai3session09.Exception;

import com.example.bai3session09.DTO.ApiResponse;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Map<String, String>>> handleValidationException(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new LinkedHashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            String fieldName = error.getField();
            String errorMessage = error.getDefaultMessage();
            errors.putIfAbsent(fieldName, errorMessage);});
        ApiResponse<Map<String, String>> response = new ApiResponse<>(
                "FAIL",
                "Dữ liệu đầu vào không hợp lệ",
                errors);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ApiResponse<String>> handleNotFoundException(
            EntityNotFoundException ex) { ApiResponse<String> response = new ApiResponse<>(
                "FAIL",
                ex.getMessage(),
                null);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
