package com.allstate.repository;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmployeeImpMySqlTest {

    EmployeeImplMySql employeeImplMySql = new EmployeeImplMySql();

    @Test
    public void testGetConnectionReturnsNotNull(){
        assertNotNull(employeeImplMySql.getConnection());
    }

    @Test
    public void testIsConnectionReturnsTrue(){
        assertTrue(employeeImplMySql.isConnected());
    }
}
