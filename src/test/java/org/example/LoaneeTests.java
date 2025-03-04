package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class LoaneeTests {

    PrivateCustomer customerOne = new PrivateCustomer("John Doe", "1");
    SchoolLibrary customerTwo = new SchoolLibrary("Armadale Primary School", "2", "West Lothian");
    PrivateCustomer customerThree = new PrivateCustomer("Jane Doe", "3");

    //Check Superclass and Loanee relationships
    @Test
    public void superclassImplementCheck(){
        assertFalse("Customer shouldn't implement the interface, only the subclasses should!", Loanee.class.isAssignableFrom(Customer.class));

        assertTrue("PrivateCustomer isn't a subclass of Customer anymore!", Customer.class.isAssignableFrom(customerOne.getClass()));
        assertTrue("SchoolLibrary isn't a subclass of Customer anymore!", Customer.class.isAssignableFrom(customerTwo.getClass()));

        assertTrue("PrivateCustomer doesn't implement the Interface", Loanee.class.isAssignableFrom(customerOne.getClass()));
        assertTrue("SchoolLibrary doesn't implement the Interface", Loanee.class.isAssignableFrom(customerTwo.getClass()));
    }


    //Print Tests
    @Test
    public void printTestsPrivate(){
        //Check Update method outputs to PrintLn
        java.io.ByteArrayOutputStream out1 = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out1));
        customerOne.update("PrintTest");
        String expected1 = out1.toString().strip();
        assertEquals("PrivateCustomer doesn't print the correct message! Is the message printed before returning, and is your formatting the same?", expected1, "John Doe PrintTest");
    }
    @Test
    public void printTestsSchool(){
        //Check Update method outputs to PrintLn
        java.io.ByteArrayOutputStream out2 = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out2));
        customerTwo.update("PrintTest");
        String expected2 = out2.toString().strip();
        assertEquals("SchoolLibrary doesn't print the correct message! Is the message printed before returning, and is your formatting correct?", expected2, "Armadale Primary School West Lothian PrintTest");
    }



}
