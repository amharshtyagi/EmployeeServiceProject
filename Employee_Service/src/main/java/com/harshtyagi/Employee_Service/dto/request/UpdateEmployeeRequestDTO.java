package com.harshtyagi.Employee_Service.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateEmployeeRequestDTO {

    private String employeeName;
    @NotNull private Long employeeId; //For partial update only empId is mandatory
    @Min(value = 18)@Max(value = 60) private Integer age;
    private String department;
}
