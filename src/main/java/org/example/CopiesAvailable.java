package org.example;

public class CopiesAvailable implements LoanState{

    //What book does when a copy is available!
    @Override
    public String loan(Book book){

        //Get a copy from book that can be loaned - i.e an available == true copy
        Copy copyToLoan = book.getAvailableCopy();
        copyToLoan.setUnavailable();

        //Subtract a book from the available books.
        book.bookTaken();

        //Helper message to say what we have done!
        System.out.println("A customer has taken out a loan on " + book.title + ". Copy Number: " + copyToLoan.copyID);

        return copyToLoan.copyID;
    }

}
