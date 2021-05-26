package com.allstate.services;

import com.allstate.entities.Employee;
import com.allstate.exceptions.OutOfRangeException;
import com.allstate.repository.EmployeeRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
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

}
