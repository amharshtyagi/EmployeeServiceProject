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
        employeeDB.add(new Employee("Harsh", 200, "harsh@comp.com", "IT"));
        employeeDB.add(new Employee("Aditya", 201, "adi@comp.com", "IT"));
        employeeDB.add(new Employee("Kshitiz", 202, "ks@comp.com", "IT"));
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
