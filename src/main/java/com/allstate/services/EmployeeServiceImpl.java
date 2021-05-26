package com.allstate.services;

import com.allstate.entities.Employee;
import com.allstate.exceptions.OutOfRangeException;
import com.allstate.repository.EmployeeRepo;

import java.util.List;
//business layer
public class EmployeeServiceImpl implements  EmployeeService{

    private EmployeeRepo employeeRepo;

    public EmployeeServiceImpl(EmployeeRepo employeeRepo){ this.employeeRepo=employeeRepo; }

    @Override
    public Employee find(int id) throws OutOfRangeException {
        if (id <1 ) {
            throw new OutOfRangeException("id must be over 0",1);
        }
        return employeeRepo.findById(id);
    }
    @Override
    public List<Employee> find(String address) throws OutOfRangeException {
        if (address.equals("")  ) {
            throw new OutOfRangeException("Address can't be blank",1);
        }
        return employeeRepo.findByAddress(address);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepo.findAll();
    }

    @Override
    public int save(Employee employee) throws OutOfRangeException {
        if (employee.getId()<1  ) {
            throw new OutOfRangeException("ID must be over 0 ",1); }
        Employee employee1 = employeeRepo.findById(employee.getId());

        if (employee1==null) {
            return employeeRepo.create(employee);
        } else {
            return  -2;
        }
    }

    @Override
    public int update(Employee employee) throws OutOfRangeException {
        if (employee.getId()<1  ) {
            throw new OutOfRangeException("ID must be over 0 ",1);
        }
        return  employeeRepo.update(employee);
    }
}