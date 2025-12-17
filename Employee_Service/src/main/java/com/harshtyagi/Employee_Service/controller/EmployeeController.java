package com.harshtyagi.Employee_Service.controller;

import com.harshtyagi.Employee_Service.model.Employee;
import com.harshtyagi.Employee_Service.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employeeService")
public class EmployeeController {

    EmployeeService service = new EmployeeService();

    @GetMapping("/hello")
    public String hello(){
        return "Hello Employee";
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return service.getListOfEmployees();
    }
}
