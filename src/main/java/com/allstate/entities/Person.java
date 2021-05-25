package com.allstate.entities;

public class Person {
    private int id;
    private String name;
    private String address;


    //default constructor
    public Person(){
        this.id=1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String display() {

        return id + this.name + this.address ;

    }

}
