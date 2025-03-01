package org.example;

public class CopiesAvailable implements LoanState{

    /**
     * This tells us what Book should do when a copy is available.
     * @param book The book instance (usually pass 'this') to loan a copy from
     * @return the copyID that represents the loaned copy
     */
    @Override
    public String loan(Book book){

        //Get a copy from book that can be loaned - i.e an available == true copy
        Copy copyToLoan = book.getAvailableCopy();
        copyToLoan.setUnavailable();

        //Subtract a book from the available books.
        book.bookTaken();

        return copyToLoan.copyID;
    }

}
