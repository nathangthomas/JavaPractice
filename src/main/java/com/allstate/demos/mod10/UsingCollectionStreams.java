package com.allstate.demos.mod10;

import com.allstate.entities.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class UsingCollectionStreams {
    public static void main(String[] args) {
        List<Double> hoursWorked = Arrays.asList(7.5, 8.25, 9.0, 7.0, 6.5);

        Stream<Double> myStream = hoursWorked.stream();
        double result = myStream.filter((d)->{return d>7.5;})
                .mapToDouble((d)-> d)
                .sum();
        System.out.println(result);

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Susan", 1, 100));
        employees.add(new Employee("Lisa", 2, 200));
        employees.add(new Employee("Robert", 3, 50));
        employees.add(new Employee("Bob", 4, 53));

        Stream<Employee> employeeStream = employees.stream();
        List<Employee> lst = employeeStream.filter((e)-> {return e.getSalary() > 75;})
                .collect(Collectors.toList());

        System.out.println(lst.size());

        Stream<Employee> employeeStream2 = employees.stream();
        DoubleStream salaryStream = employeeStream2.mapToDouble(Employee::getSalary);

        salaryStream.forEach(s -> System.out.println(" " + s));

        List<Integer> numbers = Arrays.asList(1, 55, 77, 87, 99, 100);
        Stream<Integer> stream = numbers.stream();

        stream.filter(n -> n > 70)
                .peek(n -> System.out.println("Raw mark: " + n))
                .mapToInt(n -> n - 70)
                .distinct()
                .sorted()
                .limit(10)
                .forEach(n -> System.out.println("Score above A-grade threshold: " + n));
    }
}
