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
        assertTrue("SchoolLibrary doesn't implement the Interface", Loanee.class.isAssignableFrom(custTeomerTwo.getClass()));
    }

    //Update Method Checks
    @Test
    public void updateMethodExistsPrivate(){
        assertTrue("PrivateCustomer Update Method does not return a string! Does the Update method in Loanee have the same signature as the UML?", customerOne.update("abc") instanceof String);
    }
    @Test
    public void updateMethodExistsSchool(){
        assertTrue("SchoolLibrary Update Method does not return a string! Does the Update method in Loanee have the same signature as the UML?", customerTwo.update("abc") instanceof String);
    }

    //Update Method Overrides
    @Test
    public void updateMethodOverridePrivate(){
        assertNotEquals("PrivateCustomer doesn't seem to have overridden the update method!", "Hello World", customerOne.update("Hello World"));
        assertEquals("PrivateCustomer implements Update incorrectly. Ensure the message is formatted correctly!", "John Doe Hello World", customerOne.update("Hello World"));
    }
    @Test
    public void updateMethodOverrideSchool(){
        assertNotEquals("SchoolLibrary doesn't seem to have overridden the update method!", "Hello World", customerTwo.update("Hello World"));
        assertEquals("SchoolLibrary implements Update incorrectly. Ensure the message is formatted correctly!", "Armadale Primary School West Lothian Hello World", customerTwo.update("Hello World"));
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
