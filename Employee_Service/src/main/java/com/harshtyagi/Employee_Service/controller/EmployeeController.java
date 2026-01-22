package com.harshtyagi.Employee_Service.controller;

import com.harshtyagi.Employee_Service.dto.request.CreateEmployeeRequestDTO;
import com.harshtyagi.Employee_Service.dto.response.ApiResponse;
import com.harshtyagi.Employee_Service.entity.Employee;
import com.harshtyagi.Employee_Service.mapper.EmployeeMapper;
import com.harshtyagi.Employee_Service.service.EmployeeService;
import com.harshtyagi.Employee_Service.dto.response.EmployeeResponseDTO;
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

    //For Constructor based DI
    private final EmployeeService service;
    private final EmployeeMapper mapper;

    public EmployeeController(EmployeeService service, EmployeeMapper mapper){
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping()
    public ResponseEntity<ApiResponse<List<EmployeeResponseDTO>>> getAllEmployees(){
        /*
        * Service layer interacts with entity
        * Api Response uses dto
        * that's why we map entity and dto using mapper class.
        * */
        List<Employee> employeeList = service.getAllEmployees();

        List<EmployeeResponseDTO> responseDTOList = new ArrayList<>();

        //Mapping of EmployeeResponseDTO with entity
        for(Employee employee :employeeList){
            EmployeeResponseDTO dto = mapper.toResponseDTO(employee);
            responseDTOList.add(dto);
        }

        ApiResponse<List<EmployeeResponseDTO>> apiResponse =  ApiResponse.<List<EmployeeResponseDTO>>builder()
                .status("SUCCESS")
                .message("Employees fetched successfully")
                .timeStamp(LocalDateTime.now())
                .data(responseDTOList)
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping()
    public ResponseEntity<ApiResponse<EmployeeResponseDTO>> addNewEmployee(@RequestBody @Valid CreateEmployeeRequestDTO newEmployee){
        //RequestDto to entity
        Employee employee = mapper.toEntity(newEmployee);
        //Save employee
        Employee savedEmployee = service.addEmployeeData(employee);
        //Entity to responseDto
        EmployeeResponseDTO responseDTO = mapper.toResponseDTO(savedEmployee);
        //Build API Response
        ApiResponse<EmployeeResponseDTO> response = ApiResponse.<EmployeeResponseDTO>builder()
                .status("SUCCESS")
                .message("Employee created successfully")
                .timeStamp(LocalDateTime.now())
                .data(responseDTO)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    //getById
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<EmployeeResponseDTO>> getEmpById(@PathVariable long id){
        Employee employee =service.getEmployeeById(id);

        //Mapping to convert entity(service) -> DTO(API Response)
        EmployeeResponseDTO dto = mapper.toResponseDTO(employee);

        ApiResponse<EmployeeResponseDTO> response = ApiResponse.<EmployeeResponseDTO>builder()
                .status("SUCCESS")
                .message("Employee found successfully")
                .timeStamp(LocalDateTime.now())
                .data(dto)
                .build();
        return ResponseEntity.ok(response);
    }
}
