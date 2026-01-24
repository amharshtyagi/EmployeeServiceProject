package com.harshtyagi.Employee_Service.repository;

import com.harshtyagi.Employee_Service.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
    private static final List<Employee> employeeDB = new ArrayList<>();

    static {
        employeeDB.add(Employee.builder()
                .employeeName("Harsh")
                .employeeId(200)
                .email("harsh@comp.com")
                .department("IT")
                .build());
        employeeDB.add(Employee.builder()
                .employeeName("Aditya")
                .employeeId(201)
                .email("adi@comp.com")
                .department("IT")
                .build());
        employeeDB.add(Employee.builder()
                .employeeName("Kshitiz")
                .employeeId(202)
                .email("ks@comp.com")
                .department("IT")
                .build());
    }

    @Override
    public Optional<Employee> findById(int id){
        return employeeDB.stream()
                .filter(emp -> emp.getEmployeeId() == id)
                .findFirst();
    }

    @Override
    public List<Employee> findAll(){
        return employeeDB;
    }
}
