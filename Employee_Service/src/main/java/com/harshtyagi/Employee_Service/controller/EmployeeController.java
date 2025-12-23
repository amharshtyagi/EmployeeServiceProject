package com.harshtyagi.Employee_Service.controller;

import com.harshtyagi.Employee_Service.model.Employee;
import com.harshtyagi.Employee_Service.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/addEmployee")
    public Employee addNewEmployee(@RequestBody @Valid Employee newEmployee){
        service.addEmployeeData(newEmployee);
        System.out.println("Inside addNewEmployee Controller method.");
        return newEmployee;
    }
}
