package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class SingletonTests {

    PrivateCustomer customerOne = new PrivateCustomer("John Doe", "1");
    SchoolLibrary customerTwo = new SchoolLibrary("Armadale Primary School", "2", "West Lothian");
    PrivateCustomer customerThree = new PrivateCustomer("Jane Doe", "3");
    Library L = new Library();


    //Check lazy instantiation works.
    @Test
    public void constructorChecks(){

        BooksDatabase db = BooksDatabase.getInstance();
        BooksDatabase db2 = BooksDatabase.getInstance();

        assertNotNull("The first instance created is Null. Does it create and return an instance?", db);
        assertNotNull("The second instance created is Null. Is the instance saved on the first run? Does it return the stored instance?", db2);

        assertEquals("Two instances aren't the same. Does your getInstance store the created instance, or do you create a new one every time?", db, db2);

    }

    //Check path to file is ok
    @Test
    public void pathCheck(){

        BooksDatabase db = BooksDatabase.getInstance();
        assertNotNull("The first book retrieved was null. Is the path to the csv file specified correctly?", db.getBook());

    }

    //Check files can be retrieved
    @Test
    public void booksCheck(){

        String a = BooksDatabase.getInstance().getBook();
        assertNotNull("The book retrieved was null! Are the books stored to the arraylist properly?", a);

        String b = BooksDatabase.getInstance().getBook();
        assertNotNull("The book retrieved was null! Are the books stored to the arraylist properly?", a);

        assertNotEquals("The two books retrieved are the same! Have you removed the first book when it was retrieved?", a, b);

        assertEquals("The first book was not read correctly", "The Way of Kings, Brandon Sanderson", a);
        assertEquals("The second book was not read correctly", "Dune, Frank Herbert", b);

    }








}
