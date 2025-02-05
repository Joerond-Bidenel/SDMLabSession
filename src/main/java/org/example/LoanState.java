package org.example;

public interface LoanState {

    default Copy RequestLoanBook(Loanee customer, Book book){
        return book.getCopies().get(0);
    }


}
