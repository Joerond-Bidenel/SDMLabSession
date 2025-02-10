package org.example;

import java.util.ArrayList;

public class Customer {

    String name = "";
    String ID = "";

    ArrayList<String> loaned = new ArrayList<>();

    public Customer(String name, String id) {
        this.name = name;
        this.ID = ID;
    }


    public boolean takeBook(String copyID){
        return false;
    }

    public boolean returnBook(String copyID){
        return false;
    }

}
