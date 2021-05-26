package com.allstate.services;

import com.allstate.entities.Employee;
import com.allstate.exceptions.OutOfRangeException;

import java.util.List;

public interface EmployeeService {
    Employee find(int id) throws OutOfRangeException;
    List<Employee> find(String address) throws OutOfRangeException;
    List<Employee>  findAll();
    int save(Employee employee) throws OutOfRangeException;
    int update(Employee employee) throws OutOfRangeException;
}