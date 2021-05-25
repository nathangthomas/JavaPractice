package com.allstate.demos.mod7;

public class UsingStringBuilder {
    public static void main(String[] args) {
        StringBuilder stringBuilder= new StringBuilder("Hello");
        stringBuilder.append("World\n");
        stringBuilder.append('!');

        stringBuilder.insert(5,  " Andy and the rest of the");
        stringBuilder.insert(10, 43);

        String str1 = stringBuilder.toString();
        System.out.println(str1);

        StringBuilder sb2 = stringBuilder;
        sb2.replace(6, 9, "Fred");
        sb2.reverse();

        String result= stringBuilder.toString();
        System.out.println(result);

    }
}
