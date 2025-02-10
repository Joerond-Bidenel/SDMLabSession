package org.example;

public class NoCopiesAvailable implements LoanState{

    //What book does if there are no copies available
    @Override
    public String loan(Book book){

        //Say that they've been subscribed to the waiting list!
        System.out.println("No copy was available. Add to Waiting List!");

        return null;
    }
}
