package com.allstate.repository;

import com.allstate.entities.Employee;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeImplMySql implements EmployeeRepo {


    public Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/training?serverTimezone=UTC&useSSL=false",
                    "root",
                    "c0nygre");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return con;
    }


    private Connection connection;

    public boolean isConnected(){
        Statement statement = null;
        try {
            connection = getConnection();
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select 1");
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    @Override
    public int create(Employee employee) {
        try {
            PreparedStatement preparedStatement =  this.connection
                    .prepareStatement("Insert into Employees(name, address, salary) values (?, ?, ?)");
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(1, employee.getAddress());
            preparedStatement.setDouble(1, employee.getSalary());
            return preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return -1;
        }
    }

    @Override
    public int update(Employee employee) {
        try {
            PreparedStatement preparedStatement =  this.connection
                    .prepareStatement("Update Employees set name?, address?, salary? where id=?");
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(1, employee.getAddress());
            preparedStatement.setDouble(1, employee.getSalary());
            preparedStatement.setInt(1, employee.getId());
            return preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return -1;
        }
    }

    @Override
    public Employee findById(int id) {
        try {
            PreparedStatement preparedStatement = this.connection
                    .prepareStatement("Select * from Employees where id =?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Employee employee = new Employee(
                    resultSet.getString("name"),
                    resultSet.getInt("id"),
                    resultSet.getDouble("salary"),
                    resultSet.getString("address"));
            return employee;

        } catch (SQLException throwable) {
            throwable.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> employees = new ArrayList<>();
        try {
            PreparedStatement preparedStatement= this.connection.
                    prepareStatement("SElect * From Employees");

            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()) {
                Employee employee = new Employee(
                        resultSet.getString("name"),
                        resultSet.getInt("id"),
                        resultSet.getDouble("salary"),
                        resultSet.getString("address")
                );
                employees.add(employee);
            }
            return  employees;

        } catch (SQLException  throwables) {
            throwables.printStackTrace();
            return null;
        }
    };

    @Override
    public List<Employee> findByAddress(String address) {
        List<Employee> employees = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.connection
                    .prepareStatement("Select * from Employees where address =?");
            ResultSet resultSet = preparedStatement.executeQuery();
            Employee employee = new Employee(
                    resultSet.getString("name"),
                    resultSet.getInt("id"),
                    resultSet.getDouble("salary"),
                    resultSet.getString("address"));
            return employees;

        } catch (SQLException throwable) {
            throwable.printStackTrace();
            return null;
        }
    }

    public void cleardb()
    {
        try {
            PreparedStatement preparedStatement= this.connection.
                    prepareStatement("Truncate Table Employees");
            preparedStatement.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

}
