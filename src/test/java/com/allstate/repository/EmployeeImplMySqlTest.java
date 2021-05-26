package com.allstate.repository;

import com.allstate.entities.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmployeeImplMySqlTest {

    EmployeeRepo employeeRepo = new EmployeeImplMySql();

    @BeforeEach
    public void setup(){
        employeeRepo.create(new Employee("John", 0, 10.99, "US"));
        employeeRepo.create(new Employee("Mary", 1, 11.99, "CANADA"));
        employeeRepo.create(new Employee("Jane", 2, 12.99, "US"));
    }

    @AfterEach
    public void tearDown(){
        ((EmployeeImplMySql)employeeRepo).cleardb();
    }

    @Test
    public void testIsConnectionReturnsTrue(){
        assertTrue(employeeRepo.isConnected());
    }

    @Test
    public void testCreateEmployeeReturnsSuccess(){
        int result = employeeRepo.create(new Employee("John", 1, 10.99, "US"));
        assertTrue(result!=-1);
    }

    @Test
    public void testUpdateEmployeeReturnsSuccess(){
        int result = employeeRepo.update(new Employee("James", 1, 99.99, "UK"));
    }

    @Test
    public  void testFindByAddress_Returns3Employees(){
        assertEquals(2, employeeRepo.findByAddress("US").stream().count());
    }
}
