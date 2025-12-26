package com.harshtyagi.Employee_Service.exceptionhandler;

import com.harshtyagi.Employee_Service.dto.ApiResponse;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> handleValidationException(MethodArgumentNotValidException exception){

        String message = exception.getBindingResult().getFieldError().getDefaultMessage();

        ApiResponse response = new ApiResponse();
        response.setStatus("ERROR");
        response.setMessage(message);
        response.setTimestamp(LocalDateTime.now());
        return ResponseEntity.badRequest().body(response);
    }
}
