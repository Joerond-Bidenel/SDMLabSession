package org.example;

public class NoCopiesAvailable implements LoanState{

    //What book does if there are no copies available
    @Override
    public boolean loan(Book book, Customer c){

        //We shouldn't really do this
        book.waitingList.subscribe((Loanee) c);

        //Say that they've been subscribed to the waiting list!
        System.out.println("No copy was available. Added " + c.name + " to Waiting List!");

        return true;
    }
}
