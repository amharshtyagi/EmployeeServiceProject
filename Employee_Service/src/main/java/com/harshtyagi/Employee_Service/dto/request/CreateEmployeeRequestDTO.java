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
public class CreateEmployeeRequestDTO {

    @NotBlank private String employeeName;
    @Min(value = 18)@Max(value = 60) private Integer age; //Using Wrapper type as age is optional
    @NotBlank private String department;
}
