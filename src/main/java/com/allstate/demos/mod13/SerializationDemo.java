package com.allstate.demos.mod13;

import com.allstate.entities.Employee;

import java.io.*;

public class SerializationDemo {

    public static void main(String[] args) {
        Serialize();
    }

    public static void Serialize(){
        Employee employee= new Employee("Mariuz", 12, 100.00, "Poland");

        String filename ="employee.ser";

        FileOutputStream fs = null;
        try {
            fs = new FileOutputStream(filename);
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(employee);
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Employee deserialize() {
        Employee employee = null;
        try {
            FileInputStream   fs = new FileInputStream("employee.ser");
            ObjectInputStream is = new ObjectInputStream(fs);
            employee = (Employee) is.readObject();
            is.close();
            fs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employee;
    }

}