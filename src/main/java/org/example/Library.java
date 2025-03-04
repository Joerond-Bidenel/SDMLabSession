package org.example;

import java.util.ArrayList;
import java.util.Objects;

public class Library {

    private ArrayList<Book> books = new ArrayList<>();

    public Library(){

    }

    public void addBook(Book b){
        this.books.add(b);
    }

    public ArrayList<Book> getBooks() {
        return this.books;
    }

    public boolean loanBook(String bookName, Customer customer){

        //Find the book
        for(Book b : books){
            if (Objects.equals(b.title, bookName)){

                //Try to loan the book.
                String copyToLoan = b.loanThisBook();

                //If there is a copy valid, then the customer can take it!
                //They might not want updates about this book anymore
                if (copyToLoan != null){
                    b.waitingList.unsubscribe((Loanee) customer);
                    customer.takeBook(copyToLoan);
                    return true;
                }

                b.waitingList.subscribe((Loanee) customer);
                return false;
            }
        }

        //If the book isn't found
        System.out.println("Book Not found");
        return false;
    }

    public boolean returnBook(String copyID, String bookName, Customer customer){


        for(Book b : books){
            if (Objects.equals(b.title, bookName)){


                //Try to return the book. This means that this book has the copyID
                boolean validReturn = b.bookReturned(copyID);

                //If we can return it, then do so
                if (validReturn){
                    customer.returnBook(copyID);
                    return true;
                }
                else{
                    return false;
                }
            }
        }
        System.err.println("Error returning book");
        return false;
    }

}
