package org.example;

public interface LoanState {

    default boolean loan(Book book, Customer c){
        return false;
    }


}
