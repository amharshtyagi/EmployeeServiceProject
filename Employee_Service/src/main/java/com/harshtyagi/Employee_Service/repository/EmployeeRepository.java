package com.harshtyagi.Employee_Service.repository;

import com.harshtyagi.Employee_Service.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {

    Optional<Employee> findById(int id);
    List<Employee> findAll();
}
