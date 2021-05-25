package com.allstate.demos.mod10;

import java.util.ArrayList;
import java.util.List;

public class UsingMail {
    public static void main(String[] args) {
        Mail mail = new GmailImpl();

        ((GmailImpl) mail).saveToGoogleDrive();

        List<Mail> list = new ArrayList<Mail>();
        list.add(mail);

        Mail mail2 = new OutlookImpl();
        list.add(mail2);

        for (Mail item: list){
            item.send();
        }
    }

}
