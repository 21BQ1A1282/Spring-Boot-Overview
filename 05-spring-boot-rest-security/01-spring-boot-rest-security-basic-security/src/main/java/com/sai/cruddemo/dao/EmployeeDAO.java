package com.sai.cruddemo.dao;

import java.util.*;

import com.sai.cruddemo.entity.Employee;

public interface EmployeeDAO {

    List<Employee> findAll();
    
    Employee findById(int theId);
    
    Employee save(Employee theEmployee);
    
    void deleteById(int theId);

}
