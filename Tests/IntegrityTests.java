package org.example;

import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.*;

public class IntegrityTests {

    PrivateCustomer customerOne = new PrivateCustomer("John Doe", "1");
    SchoolLibrary customerTwo = new SchoolLibrary("Armadale Primary School", "2", "West Lothian");
    PrivateCustomer customerThree = new PrivateCustomer("Jane Doe", "3");
    Library L = new Library();
    Book ffa = new Book("Flowers For Algernon", "Daniel Keyes", 1);
    Book mistborn = new Book("Mistborn", "Brandon Sanderson", 1);

    //Check Superclasses Extended
    @Test
    public void superclassCheck(){
        assertTrue("PrivateCustomer isn't a subclass of Customer", Customer.class.isAssignableFrom(customerOne.getClass()));
        assertTrue("SchoolLibrary isn't a subclass of Customer", Customer.class.isAssignableFrom(customerTwo.getClass()));


        assertTrue("PrivateCustomer Missing Superclass Functionality", Objects.equals(customerOne.name, "John Doe") && Objects.equals(customerOne.ID, "1"));
        assertTrue("SchoolLibrary Missing Superclass Functionality", Objects.equals(customerTwo.name, "Armadale Primary School") && Objects.equals(customerTwo.ID, "2") && Objects.equals(customerTwo.location, "West Lothian"));
    }

    //Test we can loan a book, and that this updates the internal state of Customer and Book
    @Test
    public void loanCheck(){
        L.addBook(ffa);
        L.addBook(mistborn);
        L.loanBook("Flowers For Algernon", customerOne);
        assertEquals("The book hasn't reduced its copy count after a book was loaned", 0, (int) ffa.noOfCopies);
        assertEquals("Customer Hasn't stored the Loaned Book", "Flowers For Algernon copy#0", customerOne.loaned.get(0));
    }

    //Test we can't loan a book when no copies are available
    @Test
    public void loanWhenNoneCheck(){
        L.addBook(ffa);
        L.addBook(mistborn);
        L.loanBook("Flowers For Algernon", customerOne);

        L.loanBook("Flowers For Algernon", customerThree);
        assertTrue("Customer loaned a book when no copies were available", customerThree.loaned.isEmpty());
        assertNotEquals("The book copy count was decremented when no copies were avaliable!", -1, (int) ffa.noOfCopies);
    }

    //Test we can return a book
    @Test
    public void returnCheck(){
        L.addBook(ffa);
        L.addBook(mistborn);
        L.loanBook("Flowers For Algernon", customerOne);

        L.returnBook("Flowers For Algernoncopy#0", "Flowers For Algernon", customerOne);
        assertFalse("Customer didn't return the book from it's list", customerOne.loaned.isEmpty());
        assertEquals("The book hasn't increased its copy count after a book was returned", 1, (int) ffa.noOfCopies);
        assertNotNull("After returning a copy, the book can't return a valid copy", ffa.getAvailableCopy());

    }

    //Test the returned book can now be loaned
    @Test
    public void loanAndReturn(){
        L.addBook(ffa);
        L.addBook(mistborn);
        L.loanBook("Flowers For Algernon", customerOne);
        L.returnBook("Flowers For Algernoncopy#0", "Flowers For Algernon", customerOne);

        L.loanBook("Flowers For Algernon", customerThree);
        assertFalse("The customer was unable to loan a copy after it was returned", customerThree.loaned.isEmpty());
        assertEquals("The book hasn't reduced its copy count after a book was loaned", 0, (int) ffa.noOfCopies);
    }

    //Test we can't return an unloaned book
    @Test
    public void loanUnloanedCheck(){
        L.addBook(ffa);
        L.addBook(mistborn);

        L.returnBook("copy0", "Mistborn", customerOne);
        assertEquals("The book has changed its copy count, even though there was nothing to return", 1, (int) mistborn.noOfCopies);

    }



}
