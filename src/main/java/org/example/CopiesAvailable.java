package org.example;

public class CopiesAvailable implements LoanState{

    //What book does when a copy is available!
    @Override
    public boolean loan(Book book, Customer c){

        //Get a copy from book that can be loaned - i.e an available == true copy
        Copy copyToLoan = book.getAvailableCopy();

        //Invoke the customer's method to handle the copy
        c.takeBook(copyToLoan);

        //Subtract a book from the available books.
        book.bookTaken();

        //Helper message to say what we have done!
        System.out.println("Customer " + c.name + " has taken out a loan on " + book.title + ". Copy Number: " + copyToLoan.copyID);

        return true;
    }

}
