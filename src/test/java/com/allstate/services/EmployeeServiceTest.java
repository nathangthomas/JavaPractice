package com.allstate.services;

import com.allstate.entities.Employee;
import com.allstate.entities.Person;
import com.allstate.exceptions.OutOfRangeException;
import com.allstate.repository.EmployeeImplMySql;
import com.allstate.repository.EmployeeRepo;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.isA;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmployeeServiceTest {
    private EmployeeRepo employeeRepo= new EmployeeImplMySql();
    private EmployeeService employeeService= new EmployeeServiceImpl(employeeRepo);
    @Test
    public void testFindByIDThrowsException() {
        Exception exception = assertThrows(OutOfRangeException.class, () -> {
            Employee employee = employeeService.find(0);
        });
    }

    @Test
    public void testFindByIDReturnanEmployeeType() throws OutOfRangeException {
        Employee employee = employeeService.find(1);
        assertThat(employee, isA(Person.class));
    }

    @Test
    public void testSaveReturnsanIntValue() throws OutOfRangeException {
        Employee employee= new Employee("Jill", 2, 10.99, "Ireland");
        int result=  employeeService.save(employee);
        assertTrue(result!=-1);
    }

}
