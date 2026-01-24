package com.harshtyagi.Employee_Service.exceptionhandler;

import com.harshtyagi.Employee_Service.dto.response.ApiResponse;
import com.harshtyagi.Employee_Service.exception.EmployeeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Map<String,String>>> handleValidationException(MethodArgumentNotValidException exception){
        //String message = exception.getBindingResult().getFieldError().getDefaultMessage();

        Map<String,String> errors = new HashMap<>();
        exception.getBindingResult().getFieldErrors()
                .forEach(error -> errors.put(error.getField(),error.getDefaultMessage()));

        ApiResponse<Map<String,String>> response = new ApiResponse<>();
        response.setStatus("FAILURE");
        response.setMessage("Validation failed");
        response.setTimeStamp(LocalDateTime.now());
        response.setData(errors);
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ApiResponse<Void>> handleEmployeeNotFoundException(EmployeeNotFoundException exception){
        String message = exception.getMessage();

        ApiResponse<Void> response = new ApiResponse<>();
        response.setStatus("FAILURE");
        response.setMessage(message);
        response.setTimeStamp(LocalDateTime.now());
        response.setData(null);
        //return ResponseEntity.badRequest().body(response); //This returns 400 which is acceptable
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response); //This returns 404, more mature response.
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleGenericException(Exception exception){

        ApiResponse<Void> response = new ApiResponse<>();
        response.setStatus("FAILURE");
        response.setMessage("Internal server error");
        response.setTimeStamp(LocalDateTime.now());
        response.setData(null);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}
