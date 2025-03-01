package org.example;

import java.util.ArrayList;

/**
 * A class representing a customer. Customers can loan and return books.
 */
public class Customer {

    String name = "";
    String ID = "";

    /**
     * A list of copyID's for all the books a customer has
     */
    ArrayList<String> loaned = new ArrayList<>();

    /**
     * Customer Constructor.
     * @param name the customer's name
     * @param id the customer's ID
     */
    public Customer(String name, String id) {
        this.name = name;
        this.ID = id;
    }

    /**
     * Customer loans a copy of a book - adding it to the internal list and whatever else it needs to do.
     * @param copyID the copy ID to return
     * @return true if they have retuned the passed copyID, false if they can't
     */
    public boolean takeBook(String copyID){
        return false;
    }

    /**
     * Customer returns a copy of a book - removing it from the internal list and whatever else it needs to do.
     * @param copyID the copy ID to return
     * @return true if they have retuned the passed copyID, false if they can't
     */
    public boolean returnBook(String copyID){
        return false;
    }

}
