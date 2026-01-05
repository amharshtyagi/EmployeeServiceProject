package com.harshtyagi.Employee_Service.controller;

import com.harshtyagi.Employee_Service.dto.ApiResponse;
import com.harshtyagi.Employee_Service.model.Employee;
import com.harshtyagi.Employee_Service.service.EmployeeService;
import com.harshtyagi.Employee_Service.dto.EmployeeResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service){
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<ApiResponse> getAllEmployees(){
        List<EmployeeResponseDTO> responseDTOList = new ArrayList<>();
        List<Employee> employeeList = service.getListOfEmployees();
        ApiResponse apiResponse = new ApiResponse();
        //Manual Mapping of Entitiy data with EmployeeResponseDTO
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

    @PostMapping()
    public ResponseEntity<ApiResponse> addNewEmployee(@RequestBody @Valid Employee newEmployee){
        service.addEmployeeData(newEmployee);

        ApiResponse response = new ApiResponse();

        response.setStatus("SUCCESS");
        response.setMessage("Employee created successfully");
        response.setTimestamp(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    //getById
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getEmpById(@PathVariable int id){
        Employee employee =service.findbyId(id);
        ApiResponse response = new ApiResponse();

        //Manual Mapping of Entitiy data with EmployeeResponseDTO dto to avoid returning entity data directly
        EmployeeResponseDTO dto = new EmployeeResponseDTO();
        dto.setEmployeeId(employee.getEmployeeId());
        dto.setEmployeeName(employee.getEmployeeName());
        dto.setEmail(employee.getEmail());
        dto.setDepartment(employee.getDepartment());

        response.setStatus("SUCCESS");
        response.setMessage("Employee found successfully");
        response.setTimestamp(LocalDateTime.now());
        response.setData(dto);
        return ResponseEntity.ok(response);
    }
}
