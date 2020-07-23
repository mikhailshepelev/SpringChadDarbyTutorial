package com.luv2code.springdatajpa.dao;

import com.luv2code.springdatajpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
