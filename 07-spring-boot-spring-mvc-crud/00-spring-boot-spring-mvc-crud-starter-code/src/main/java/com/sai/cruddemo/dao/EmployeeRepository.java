package com.sai.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sai.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
