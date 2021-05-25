package com.allstate.demos.mod10;

import java.sql.SQLOutput;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class UsingLamdas {
    public static void main(String[] args) {
//        the long way
        GreetingServiceImpl greetingService = new GreetingServiceImpl();
        greetingService.sayMessage("Nathan");

//        using lamdas
        GreetingService greetingService1 = (s)->{
            System.out.println("Hello again " + s);
        };

        greetingService1.sayMessage("Nathan");

        Math math = (x,y)->{
            return x + y;
        };

        int result = math.add(22,10);
        System.out.println(result);

//        built in lamdas
//        functional programming
        Predicate predicate = (s)->{
            if(s.equals("Nathan")){
                return true;
            } else {
                return false;
            }
        };
        System.out.println(predicate.test("Nathan"));

        Consumer consumer = (s)->{
            System.out.println(s);
        };
        consumer.accept("Nathan");

        Supplier supplier =()->{
            return "Nathan Thomas";
        };
        System.out.println(supplier.get());
    }

}
