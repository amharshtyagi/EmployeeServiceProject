package com.harshtyagi.Employee_Service.mapper;

import com.harshtyagi.Employee_Service.dto.request.CreateEmployeeRequestDTO;
import com.harshtyagi.Employee_Service.dto.response.EmployeeResponseDTO;
import com.harshtyagi.Employee_Service.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    //DTO (RequestDTO) to Entity
    public Employee toEntity(CreateEmployeeRequestDTO dto){
        Employee employee = new Employee();
        employee.setEmployeeName(dto.getEmployeeName());
        employee.setDepartment(dto.getDepartment());
        return employee;
    }

    //Entity to DTO (ResponseDTO)
    public EmployeeResponseDTO toResponseDTO(Employee entity){
        EmployeeResponseDTO dto = new EmployeeResponseDTO();
        dto.setEmployeeId(entity.getEmployeeId());
        dto.setEmployeeName(entity.getEmployeeName());
        dto.setEmail(entity.getEmail());
        dto.setDepartment(entity.getDepartment());
        return dto;
    }
}
