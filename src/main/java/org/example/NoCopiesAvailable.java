package org.example;

public class NoCopiesAvailable implements LoanState{

    //What book does if there are no copies available
    @Override
    public String loan(Book book){
        return null;
    }
}
