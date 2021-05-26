package com.allstate.services;

import com.allstate.entities.Employee;
import com.allstate.exceptions.OutOfRangeException;
import com.allstate.repository.EmployeeRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceMockTest {
    @Mock
    private EmployeeRepo employeeRepo;


    @Test
    public void testFindByIDThrowsException() {
        EmployeeService employeeService= new EmployeeServiceImpl(employeeRepo);
        Exception exception = assertThrows(OutOfRangeException.class, () -> {
            Employee employee = employeeService.find(0);
        });
    }

    @Test
    public void testFindByIDReturnanEmployee() throws OutOfRangeException {
        EmployeeService employeeService= new EmployeeServiceImpl(employeeRepo);
        Employee employee= new Employee("Jenny", 1, 10.99, "Ireland");
        when(employeeRepo.findById(1)).thenReturn(employee);

        Employee employeeresult = employeeService.find(1);
        assertTrue(employeeresult.getName().equals("Jenny"));

    }

    @Test
    public void testSaveReturnsanIntValue() throws OutOfRangeException {
        EmployeeService employeeService= new EmployeeServiceImpl(employeeRepo);
        Employee employee= new Employee("Jill", 2, 10.99, "Ireland");
        int result=  employeeService.save(employee);
        assertTrue(result!=-1);
    }

    @Test
    public  void testFindByAddressThrowsException(){
        EmployeeService employeeService = new EmployeeServiceImpl(employeeRepo);

        assertThrows(OutOfRangeException.class, ()->{
                List<Employee> employees= (List<Employee>) employeeService.find("");
        });
    }

    @Test
    public void testFindByAddressReturnsAListOfEmployees() throws OutOfRangeException {
        EmployeeService employeeService = new EmployeeServiceImpl(employeeRepo);
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Jill", 2, 10.99, "Ireland"));
        when(employeeRepo.findByAddress("Ireland")).thenReturn(employees);

        assertTrue(employeeService.find("Ireland").size()>0);
    }

//    @Test
//    public void testFindByAddressReturnsAListOfEmployees() throws OutOfRangeException {
//        EmployeeService employeeService= new EmployeeServiceImpl(employeeRepo);
//        List<Employee> employees = new ArrayList<>();
//        // employees.add(new Employee("Jenny", 1, 10.99, "Clare"));
//        // employees.add(new Employee("Billy", 1, 10.99, "Clare"));
//
//        //when(employeeRepo.findByAddress("Clare")).thenReturn(employees);
//
//        //when(employeeRepo.findByAddress("Cork")).thenReturn(employees);
//        when(employeeRepo.findByAddress( ArgumentMatchers.anyString())).thenReturn(employees);
//        when(employeeRepo.findByAddress("Clare")).
//                thenReturn((List<Employee>) employees.stream().filter((x)->{return x.getAddress().equals("Clare");}));
//
//        // assertNotNull(employees);
//        assertTrue( employeeService.find("Clare").size()>=0);
//        verify(employeeService.find("Clare"));
//
//    }

    @Test
    public void testFindAll_ReturnsListOfEmployees() throws OutOfRangeException {
        EmployeeService employeeService = new EmployeeServiceImpl(employeeRepo);
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Jill", 2, 10.99, "Ireland"));
        employees.add(new Employee("Jane", 2, 22.88, "Uk"));

        when(employeeRepo.findAll()).thenReturn(employees);
        assertTrue(employeeService.findAll().size()==2);
    }

    @Test
    public void testSave_checksForExistingRecord() throws OutOfRangeException {
        EmployeeService employeeService= new EmployeeServiceImpl(employeeRepo);

        Employee employee= new Employee("Mariuz", 12, 100.00, "Poland");
        when(employeeRepo.findById(12)).thenReturn(null);
        when(employeeRepo.create(employee)).thenReturn(Math.abs(anyInt()));
        assertTrue( employeeService.save(employee)>=0);
        verify(employeeRepo).create(employee);
    }


}
