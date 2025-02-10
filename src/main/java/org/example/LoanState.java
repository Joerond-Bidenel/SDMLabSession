package org.example;

public interface LoanState {

    default String loan(Book book){
        return null;
    }


}
