package com.harshtyagi.Employee_Service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse<T> { //Making APIResponse have a generic param to accept ResponseDTO in controller.
    private String status;
    private String message;
    private LocalDateTime timeStamp;
    private T data; //Generic type as APIResponse can now accept data type of any Request DTO
}
