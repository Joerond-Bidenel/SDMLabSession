package org.example;

public class Customer {

    String name = "";
    String ID = "";

    public Customer(String name, String id) {
        this.name = name;
        this.ID = ID;
    }


    public boolean takeBook(Copy c){
        return false;
    }

    public boolean returnBook(Copy c){
        return false;
    }

}
