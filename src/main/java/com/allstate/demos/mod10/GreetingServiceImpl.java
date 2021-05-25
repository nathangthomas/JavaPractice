package com.allstate.demos.mod10;

public class GreetingServiceImpl implements GreetingService {
    @Override
    public void sayMessage(String message) {
        System.out.println("Hi " + message);
    }
}
