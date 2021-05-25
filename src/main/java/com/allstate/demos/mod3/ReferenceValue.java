package com.allstate.demos.mod3;

import com.allstate.entities.Person;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ReferenceValue {

    public static void main(String[] args) {

        int a = 10;
        int b = 20;

        a = b;
        b = 30;
        System.out.println(a);

        Person person1 = new Person();
        person1.setName("dee");

        Person person2 = person1;
        person2.setName("Deirdre");

        System.out.println(person2.getName());
        System.out.println(person1.getName());


        if (c1() | c2()) {
            System.out.println(x);
        }

    }
    static int x=0;
    static boolean  c1() {
        x++;
        return true;
    }


    static boolean c2() {
        x++;
        return true;
    }
}
