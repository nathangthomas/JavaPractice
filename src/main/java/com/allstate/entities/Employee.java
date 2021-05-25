package com.allstate.entities;

public class Employee  extends Person{

    private double salary;

    public Employee(){
        this.salary = 0;
    }

    public Employee(double salary) {
        this.salary = salary;
    }

    public Employee(String name, int id, double salary) {
        this.setId(id);
        this.setName(name);
        this.setSalary(salary);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void incrementSalary(double salary){
        this.salary += salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "salary=" + salary +
                '}';
    }

}
