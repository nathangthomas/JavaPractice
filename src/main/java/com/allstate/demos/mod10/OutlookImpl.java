package com.allstate.demos.mod10;

public class OutlookImpl implements Mail{

    @Override
    public void send() {
        System.out.println("outlook send");
    }

    @Override
    public void receive() {
        System.out.println("outlook receive");
    }

    @Override
    public int getTotal() {
        return 100;
    }

    public void archive() {
        System.out.println("outlook archive");
    }

}
