package com.allstate.services;

import com.allstate.entities.Employee;
import com.allstate.exceptions.OutOfRangeException;

import java.util.List;

public interface EmployeeService {
    Employee find(int id) throws OutOfRangeException;
    List<Employee> findAll();
}
