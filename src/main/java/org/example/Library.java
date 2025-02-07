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

    public boolean loanBook(String bookname, Customer customer){

        //Find the book
        for(Book b : books){
            if (Objects.equals(b.title, bookname)){
                //Try to loan the book.
                b.loanThisBook(customer);
                return true;
            }
        }
        System.out.println("Book Not found");
        return false;
    }

    public void returnBook(Copy copy, Customer customer){

        //Remove the copy from customer by returning it.
        // If they can do this, then also return the copy instance
        if (customer.returnBook(copy)){
            copy.setAvailable();
        }
        else{
            System.err.println("Error returning book");
        }


    }

}
