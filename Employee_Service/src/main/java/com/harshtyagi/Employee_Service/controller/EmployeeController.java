package com.harshtyagi.Employee_Service.controller;

import com.harshtyagi.Employee_Service.dto.ApiResponse;
import com.harshtyagi.Employee_Service.model.Employee;
import com.harshtyagi.Employee_Service.service.EmployeeService;
import com.harshtyagi.Employee_Service.dto.EmployeeResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
    public ResponseEntity<ApiResponse> getAllEmployees(){
        List<EmployeeResponseDTO> responseDTOList = new ArrayList<>();
        List<Employee> employeeList = new ArrayList<>();
        ApiResponse apiResponse = new ApiResponse();
        employeeList = service.getListOfEmployees();
        for(Employee employee :employeeList){
            EmployeeResponseDTO employeeResponseDTO = new EmployeeResponseDTO();
            employeeResponseDTO.setEmployeeId(employee.getEmployeeId());
            employeeResponseDTO.setEmployeeName(employee.getEmployeeName());
            employeeResponseDTO.setEmail(employee.getEmail());
            employeeResponseDTO.setDepartment(employee.getDepartment());
            responseDTOList.add(employeeResponseDTO);
        }
        apiResponse.setStatus("SUCCESS");
        apiResponse.setMessage("Employees fetched successfully");
        apiResponse.setTimestamp(LocalDateTime.now());
        apiResponse.setData(responseDTOList);
        return ResponseEntity.ok(apiResponse);
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
