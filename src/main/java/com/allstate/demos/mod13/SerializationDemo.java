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

}