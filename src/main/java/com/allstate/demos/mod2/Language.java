package com.allstate.demos.mod2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Language {

    public void variableDemo() {
        int x = 100;
        float y = 10.2f;
        System.out.println(x);
    }

    public void fileDemo(){
        try {
            FileWriter fileWriter = new FileWriter("notes.txt", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void demoScanner() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter a String: ");
        String s = scanner.next();
        System.out.print("Enter an int: ");
        int i = scanner.nextInt();
        System.out.print("Enter a double: ");
        double d = scanner.nextDouble();
        System.out.println("Your string was " + s);
        System.out.println("Your integer was " + i);
        System.out.println("Your double was " + d);
    }


}
