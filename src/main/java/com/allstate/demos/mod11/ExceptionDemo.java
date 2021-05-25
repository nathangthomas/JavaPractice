package com.allstate.demos.mod11;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ExceptionDemo {
    public static void main(String[] args) {
        testWithAsserts();
        PrintWriter out = null;

        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter("Myfile.txt")));
            out.println("Hello world.");
            out.println("Thank you, and goodnight.");
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    private static void testWithAsserts() {
        int tz1 = getTimeZoneWithAsserts(60);
        assert tz1 == 4 : "Invalid timezone result: " + tz1;

        int tz2 = getTimeZoneWithAsserts(200);
    }

    private static int getTimeZoneWithAsserts(int longitude) {
        assert longitude >= -180 && longitude < 180 :
                "longitude " + longitude + " out of range";
        return longitude / 15;
    }

}
