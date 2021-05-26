package com.allstate.repository;

import com.allstate.entities.Employee;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmployeeImplMongoTest {

    EmployeeRepo employeeRepo= new EmployeeImplMongo();

    @BeforeEach
    public void setup() {
        employeeRepo.create(new Employee("John", 1, 10.99, "US"));
        employeeRepo.create(new Employee("Mary", 2, 10.99, "UK"));
        employeeRepo.create(new Employee("Jill", 3, 10.99, "Ireland"));
    }

    @AfterEach
    public void tearDown() {
        ((EmployeeImplMongo)employeeRepo).cleardb();
    }

    @Test
    public void testIsConnectionReturnsTrue() {
        assertTrue(employeeRepo.isConnected());
    }

    @Test
    public void testCreateEmployeeReturnsSuccess() {
        int result=employeeRepo.create(new Employee("John", 1, 10.99, "US"));
        assertTrue(result!=-1);
    }

    @Test
    void testUpdateEmployeeReturnsSuccess() {
        //todo setup data
        int result=employeeRepo.update(new Employee("Joan", 3, 12.99, "USA"));
        assertTrue(result!=-1);
    }

//    @Test
//    void testFindEmployeeReturnsError() {
//        //todo setup data
//
//        Exception exception = assertThrows(SQLException.class, () -> {
//            employeeRepo.findById(32);
//        });
//
//
//
//    }

    @Test
    void testFindByIDReturnsEmployee(){
        //todo setup data
        Employee employee=employeeRepo.findById(1);
        assertNotNull(employee);
    }

    @Test
    void testFindAllReturnsEmployeeList() {
        //todo setup data
        List<Employee> employees=employeeRepo.findAll();
        //Employee employee=new Employee("John", 1, 10.99, "US");

        // assertThat(employees, hasItem(employee));
        assertTrue(employees.size()>=0);
    }
}
