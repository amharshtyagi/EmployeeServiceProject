package com.harshtyagi.Employee_Service.exception;

public class EmployeeNotFoundException extends RuntimeException{

    // Constructor accepting a message
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
