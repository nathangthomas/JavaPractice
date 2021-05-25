package com.allstate.repository;

import com.allstate.entities.Employee;

import java.util.List;

public interface EmployeeRepo {
    int create(Employee employee);
    int update(Employee employee);

    Employee findById(int id);
    List<Employee> findAll();
    List<Employee> findByAddress(String address);

}
