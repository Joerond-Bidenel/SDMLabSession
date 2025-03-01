package org.example;

import java.util.ArrayList;
import java.util.Objects;

/**
 * A library manages a set of Books and Customers.
 *
 */
public class Library {

    private ArrayList<Book> books = new ArrayList<>();

    /**
     * Call functions in Book and Customer to loan a copy of a book.
     * Checks and finds an available from Book. Then Customer Loans the book.
     *
     * @param bookName the book to find a copy to loan
     * @param customer the customer to loan the copy to, if we find one
     * @return true if we could loan the copy, false otherwise
     */
    public boolean loanBook(String bookName, Customer customer){

        //Find the book based on the passed title
        for(Book b : books){
            if (Objects.equals(b.title, bookName)){

                //Try to loan the book by finding a copy
                String copyToLoan = b.loanThisBook();

                //If there is a copy valid, then the customer can take it!
                if (copyToLoan != null){
                    customer.takeBook(copyToLoan);
                    return true;
                }

                return false;
            }
        }

        //If the book isn't found
        System.err.println("Book Not found");
        return false;
    }


    /**
     * Return a copy of a book. The customer returns the book copy, then add it back to the library system
     * @param copyID the copy (by ID) we are trying to return
     * @param bookName the name of the book we are trying to return.
     * @param customer the name of the customer returning the copy.
     * @return True if the book was returned, false otherwise.
     */
    public boolean returnBook(String copyID, String bookName, Customer customer){

        //Find the book we want to return.
        for(Book b : books){
            if (Objects.equals(b.title, bookName)){

                //Try to return the copy of this book. This means that this book has the copyID.
                //It will be false if this book can't be returned (say, if it was never loaned in the first place.
                boolean validReturn = b.bookReturned(copyID);

                //If the return is valid, and has been entered into the system, then the customer can remove it.
                if (validReturn){
                    customer.returnBook(copyID);
                    return true;
                }
                //Otherwise, the customer can't loan the book
                else{
                    return false;
                }
            }
        }
        System.err.println("Error returning book");
        return false;
    }


    /**
     * Add a book to the library
     * @param b the Book instance to add
     */
    public void addBook(Book b){
        this.books.add(b);
    }

    /**
     * Get All books in the Library
     * @return an arraylist of all book objects in no particular order
     */
    public ArrayList<Book> getBooks() {
        return this.books;
    }

}
