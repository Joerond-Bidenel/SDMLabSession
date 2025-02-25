package org.example;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class WaitingListTests {

    @Test
    public void testQuestion2_2(){

        Book b = new Book("book", "author", 2);
        PrivateCustomer customerOne = new PrivateCustomer("John Doe", "1");
        SchoolLibrary customerTwo = new SchoolLibrary("Armadale Primary School", "2", "West Lothian");
        PrivateCustomer customerThree = new PrivateCustomer("Jane Doe", "3");

        //Can we create, add and remove waiting list stuff?
        System.err.println("\n Test Set 1 - Is the Waiting List class added correctly");
        WaitingList w = new WaitingList();

        w.subscribe(customerOne);
        assertEquals("The waiting list has stored our Loanee incorrectly - does the subscribe method store the Loanee correctly?", List.of(customerOne), w.getsubscribed());

        w.unsubscribe(customerOne);
        assertEquals("The waiting list failed to remove it's subscriber - does your Unsubscribe method work correctly?", List.of(), w.getsubscribed());


        System.err.println("\n Test Set 2 - Can We notify Subscribers?");

        //Check the NotifySubscribers method
        w.subscribe(customerOne);

        //Check something is output
        w.notifySubscribers("Hello World");
        java.io.ByteArrayOutputStream out1 = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out1));
        String expected1 = out1.toString().strip();
        assertNotNull("Update hasn't produced any message when called. Check your update method in the Loanee classes, and the notifySubscribers Method in Waiting List", expected1);

        //Check that the formatting is correct
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));
        String rand = String.valueOf(Math.random());
        w.notifySubscribers(rand);
        String expected = out.toString().strip();
        assertEquals("Customer hasn't printed the message correctly - check the formatting of the message", expected, "John Doe " + rand);
    }

    @Test
    public void testFunctionsReturnValues(){

    }

    @Test
    public void testAddLoanee(){

    }

    @Test
    public void testRemoveLoanee(){

    }

    @Test




}
