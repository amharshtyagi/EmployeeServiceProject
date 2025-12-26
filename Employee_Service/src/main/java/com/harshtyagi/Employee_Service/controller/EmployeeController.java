package com.harshtyagi.Employee_Service.controller;

import com.harshtyagi.Employee_Service.dto.ApiResponse;
import com.harshtyagi.Employee_Service.model.Employee;
import com.harshtyagi.Employee_Service.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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
    public ResponseEntity<ApiResponse> addNewEmployee(@RequestBody @Valid Employee newEmployee){
        service.addEmployeeData(newEmployee);

        ApiResponse response = new ApiResponse();

        response.setStatus("SUCCESS");
        response.setMessage("Employee created successfully");
        response.setTimestamp(LocalDateTime.now());
        return ResponseEntity.ok(response);
    }
}
