package com.allstate.repository;

import com.allstate.entities.Employee;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class EmployeeImplMongo implements EmployeeRepo {
    private MongoDatabase database;

    private void getDatabase() {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        this.database = mongoClient.getDatabase("training");
    }

    public EmployeeImplMongo() {
        getDatabase();
    }

    public void cleardb() {
        MongoCollection<Document> collection = database.getCollection("employees");
        collection.deleteMany(new Document());
    }


    @Override
    public int create(Employee employee) {
        MongoCollection<Document> collection = database.getCollection("employees");

        Document document = new Document(
                "name", employee.getName())
                .append("id", employee.getId())
                .append("address", employee.getAddress())
                .append("salary", employee.getSalary());
        try {
            collection.insertOne(document);
            return 0;
        }
        catch (MongoException mongoException)
        {
            mongoException.printStackTrace();
            return -1;
        }
    }

    @Override
    public int update(Employee employee) {
        return 0;
    }

    @Override
    public Employee findById(int id) {

        MongoCollection<Document> collection = database.getCollection("employees");

        Document myDoc = collection.find(eq("id", id)).first();
        Employee employee= new Employee();
        employee.setId(myDoc.getInteger("id"));
        employee.setName(myDoc.getString("name"));
        employee.setAddress(myDoc.getString("Address"));
        employee.setSalary(myDoc.getDouble("salary"));



        return employee;
    }

    @Override
    public List<Employee> findAll() {

        List<Employee> employees= new ArrayList<>();

        MongoCollection<Document> collection = database.getCollection("employees");


        collection.find().forEach((Block<Document>) myDoc -> {
            Employee employee= new Employee();
            employee.setId(myDoc.getInteger("id"));
            employee.setName(myDoc.getString("name"));
            employee.setAddress(myDoc.getString("Address"));
            employee.setSalary(myDoc.getDouble("salary"));
            employees.add(employee);
        });

        return employees;



    }

    @Override
    public List<Employee> findByAddress(String address) {
        return null;
    }

    @Override
    public boolean isConnected() {
        MongoCollection<Document> collection = database.getCollection("employees");
        if (collection.count()>=0)
        {
            return  true;
        }
        else {
            return false;
        }
    }

}
