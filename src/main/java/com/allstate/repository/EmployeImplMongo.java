package com.allstate.repository;

import com.allstate.entities.Employee;

import java.util.List;

public class EmployeImplMongo implements EmployeeRepo {
    @Override
    public int create(Employee employee) {
        return 0;
    }

    @Override
    public int update(Employee employee) {
        return 0;
    }

    @Override
    public Employee findById(int id) {
        return null;
    }

    @Override
    public List<Employee> findAll() {
        return null;
    }

    @Override
    public List<Employee> findByAddress(String address) {
        return null;
    }
}
