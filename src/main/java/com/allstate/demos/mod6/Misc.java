package com.allstate.demos.mod6;

import java.util.ArrayList;

public class Misc {
    public static void boxing()
    {
        ArrayList arrayList = new ArrayList();

        arrayList.add(123);
        arrayList.add("dee");

        int result= (Integer) arrayList.get(0);
        vargsDemo("dee", 1, 4,5);

    }

    public static void vargsDemo(String name , Object...others) {
        for (Object item: others) {

        }
    }

}
