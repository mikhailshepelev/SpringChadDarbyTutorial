package com.luv2code.thymeleafcrud.service;

import com.luv2code.thymeleafcrud.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int theId);

    void save(Employee theEmployee);

    void deleteById(int theId);
}
