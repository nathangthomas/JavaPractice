package com.allstate.demos.mod2;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Person {
    private int id;
    private String name;
    private String address;

    // default constructor
    public Person(){
        this.id = 1;
    }

}

