package org.example;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

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
        assertEquals("The waiting list has stored our Loanee incorrectly - does the subscribe method store the Loanee correctly?", List.of(customerOne), w.getSubscribed());

        w.unsubscribe(customerOne);
        assertEquals("The waiting list failed to remove it's subscriber - does your Unsubscribe method work correctly?", List.of(), w.getSubscribed());


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
    public void testGetSubscribed(){
        WaitingList w = new WaitingList();
        assertEquals("Waiting List GetSubscribed does not return an ArrayList! Is the method Signature correct, and does it return the correct data?", ArrayList.class , w.getSubscribed().getClass());
    }

    @Test
    public void testAddLoanee(){
        Book b = new Book("book", "author", 2);
        PrivateCustomer customerOne = new PrivateCustomer("John Doe", "1");
        PrivateCustomer customerTwo = new PrivateCustomer("Jane Doe", "2");
        PrivateCustomer customerThree = new PrivateCustomer("Marneus Calgar", "3");

        //Store One Loanee!
        WaitingList w = new WaitingList();
        w.subscribe(customerOne);
        ArrayList<Loanee> expected = new ArrayList<Loanee>();
        expected.add(customerOne);

        assertEquals("The Waiting List has a different size than expected when adding One Loanee! Do you add the Loanee to the list? Is the returned list the same as the one where Loanees are stored?", expected.size(), w.getSubscribed().size());
        assertEquals("The waiting list is the expected length, but the correct loanee data hasn't been saved! Check the Subscribe method!", expected, w.getSubscribed());

        //Try storing Three
        w.subscribe(customerTwo);
        w.subscribe(customerThree);
        expected.add(customerTwo);
        expected.add(customerThree);

        assertEquals("The Waiting List has a different size than expected! Do you overwrite Loanees when you add them? Do you only return a set amount of Loanees in getSubscribed?", expected.size(), w.getSubscribed().size());
        assertEquals("The waiting list is the expected length, but the correct Loanee data hasn't been saved! Check the Subscribe method!", expected, w.getSubscribed());

    }

    @Test
    public void testRemoveLoanee(){

        Book b = new Book("book", "author", 2);
        PrivateCustomer customerOne = new PrivateCustomer("John Doe", "1");
        PrivateCustomer customerTwo = new PrivateCustomer("Jane Doe", "2");
        PrivateCustomer customerThree = new PrivateCustomer("Marneus Calgar", "3");

        WaitingList w = new WaitingList();

        //Store a Loanee!
        w.subscribe(customerOne);

        //Remove said Loanee
        w.unsubscribe(customerOne);
        assertEquals("There should be no Loanees in the Waiting List, but something is! Check your Unsubscribe Method!", 0, w.getSubscribed().size());


        //Try with multiple Loanees
        w.subscribe(customerOne);
        w.subscribe(customerTwo);
        w.subscribe(customerThree);

        w.unsubscribe(customerTwo);

        ArrayList<Loanee> expected = new ArrayList<Loanee>();
        expected.add(customerOne);
        expected.add(customerThree);

        assertEquals("There should be two loanees in the Waiting List, but this was not observed? Do you remove the correct number of loanees in Unsubscribe?", expected.size(), w.getSubscribed().size());
        assertEquals("The loanees in the Waiting List are unexpected. Did you remove the correct Loanee?", expected, w.getSubscribed());
    }

    @Test
    public void testNotifySubscribers(){

        Book b = new Book("book", "author", 2);
        PrivateCustomer customerOne = new PrivateCustomer("John Doe", "1");
        PrivateCustomer customerTwo = new PrivateCustomer("Jane Doe", "2");
        PrivateCustomer customerThree = new PrivateCustomer("Marneus Calgar", "3");

        WaitingList w = new WaitingList();

        w.subscribe(customerOne);

        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));
        w.notifySubscribers("HelloTest");
        String expected = out.toString().strip();

        assertEquals("The subscribers are not notified when notifySubscribers is called. Check your method to see it calls update() in all Loanees.", "John Doe HelloTest", expected);
    }

    @Test
    public void testNotifyManySubscribers(){

        PrivateCustomer customerOne = new PrivateCustomer("John Doe", "1");
        PrivateCustomer customerTwo = new PrivateCustomer("Jane Doe", "2");
        PrivateCustomer customerThree = new PrivateCustomer("Marneus Calgar", "3");

        WaitingList w = new WaitingList();

        w.subscribe(customerOne);
        w.subscribe(customerTwo);
        w.subscribe(customerThree);

        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));
        w.notifySubscribers("HelloTest");
        List<String> expected = out.toString().strip().lines().toList();

        assertEquals("With three Loanees, the first is not notified when NotifySubscribers is called", "John Doe HelloTest", expected.get(0));
        assertEquals("With three Loanees, the second is not notified when NotifySubscribers is called", "Jane Doe HelloTest", expected.get(1));
        assertEquals("With three Loanees, the third is not notified when NotifySubscribers is called", "Marneus Calgar HelloTest", expected.get(2));

    }




}
