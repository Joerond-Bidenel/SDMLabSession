package org.example;

/**
 * A loanstate need implement this one method.
 */
public interface LoanState {

    default String loan(Book book){
        return null;
    }


}
