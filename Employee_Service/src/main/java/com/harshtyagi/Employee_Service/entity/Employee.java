package com.harshtyagi.Employee_Service.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private String employeeName;
    private long employeeId;
    private String email;
    private String department;
}
