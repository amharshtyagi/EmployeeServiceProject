package com.harshtyagi.Employee_Service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponseDTO {
    private Long employeeId;
    private String employeeName;
    private String email;
    private String department;
}
