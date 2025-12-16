package com.harshtyagi.Employee_Service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employeeService")
public class EmployeeController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello Employee";
    }
}
