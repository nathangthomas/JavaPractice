package com.allstate.demos.mod10;

public class GmailImpl implements Mail {

    @Override
    public void send() {
        System.out.println("Gmail send");
    }

    @Override
    public void receive() {
        System.out.println("Gmail receive");
    }

    @Override
    public int getTotal() {
        return 200;
    }

    public void saveToGoogleDrive(){
        System.out.println("Gmail save");
    }

}
