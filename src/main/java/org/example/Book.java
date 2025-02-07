package org.example;

import javax.print.attribute.standard.Copies;
import java.util.ArrayList;

public class Book {

    String title;
    String author;
    Integer noOfCopies;
    LoanState currentState;
    private final LoanState[] possibleStates = {new NoCopiesAvailable(), new CopiesAvailable()};
    WaitingList waitingList;
    ArrayList<Copy> copies = new ArrayList<>();


    //Constructor Method
    public Book(String title, String author, Integer NoOfCopies) {

        this.title = title;
        this.author = author;
        this.noOfCopies = NoOfCopies;
        this.waitingList = new WaitingList();
        for (int i = 0; i < NoOfCopies; i++){
            ChangeState(true);
            copies.add(new Copy("copy" + i, this));
        }

    }

    public void bookReturned(){

        if (this.noOfCopies == 0){
            ChangeState(true);
        }

        this.waitingList.notifySubscribers("There are copies of " + this.title + " available!");
        this.noOfCopies += 1;
    }

    public void bookTaken(){

        this.noOfCopies -= 1;
        if (noOfCopies == 0){
            this.waitingList.notifySubscribers("There are no copies of the book " + this.title + " available!");
            ChangeState(false);
        }
    }

    public boolean loanThisBook(Customer c){
        return this.currentState.loan(this, c);
    }


    //Changes the state.
    private void ChangeState(Boolean availableCopies){
        if (availableCopies){
            this.currentState = possibleStates[1];
        }
        else{
            this.currentState = possibleStates[0];
        }
    };

    public Copy getAvailableCopy(){
        for (Copy copy : copies){
            if (copy.isAvailable()){
                copy.setUnavailable();
                return copy;
            }
        }
        return null;
    }
};



