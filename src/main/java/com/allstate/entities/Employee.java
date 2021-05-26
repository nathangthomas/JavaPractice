package com.allstate.entities;

import java.io.Serializable;

public class Employee  extends Person implements Serializable {

    public Employee() {
        this.salary = 0;
    }


    public Employee(String name, int id, double salary) {
        this.setId(id);
        this.setName(name);
        this.salary = salary;
    }

    public Employee(String name, int id, double salary, String address) {
        this.setId(id);
        this.setName(name);
        this.salary = salary;
        this.setAddress(address);
    }


    public Employee(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    private double salary;
    public void incrementSalary(double salary) {
        this.salary+=salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "salary=" + salary +
                '}';
    }
}
