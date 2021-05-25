package com.allstate.services;

import com.allstate.entities.Employee;
import com.allstate.exceptions.OutOfRangeException;

import java.util.List;

public class EmployeeServiceInpl implements EmployeeService{
    @Override
    public Employee find(int id) throws OutOfRangeException{
        if (id<1){
            throw new OutOfRangeException("id must be over 0", 1);
        }
        return null;
    }

    @Override
    public List<Employee> findAll(){
        return null;
    }
}
