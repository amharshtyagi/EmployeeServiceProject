package com.harshtyagi.Employee_Service.exceptionhandler;

import com.harshtyagi.Employee_Service.dto.ApiResponse;
import com.harshtyagi.Employee_Service.exception.EmployeeNotFoundException;
import org.springframework.http.HttpStatus;
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

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ApiResponse> handleEmployeeNotFoundException(EmployeeNotFoundException exception){
        String message = exception.getMessage();

        ApiResponse response = new ApiResponse();
        response.setStatus("FAILURE");
        response.setMessage(message);
        response.setTimestamp(LocalDateTime.now());
        response.setData(null);
        //return ResponseEntity.badRequest().body(response); //This returns 400 which is acceptable
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response); //This returns 404, more mature response.
    }
}
