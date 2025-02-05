package org.example;

import javax.print.attribute.standard.Copies;
import java.util.ArrayList;

public class Book {

    String title;
    String author;
    LoanState currentState;
    LoanState[] possibleStates = {new NoCopiesAvailable(), new CopiesAvailable()};
    WaitingList waitingList = new WaitingList();
    ArrayList<Copy> copies = new ArrayList<>();


    //Constructor Method
    public Book(String title, String author, Integer NoOfCopies) {

        this.title = title;
        this.author = author;
        for (int i = 0; i < NoOfCopies; i++){
            ChangeState(true);
            copies.add(new Copy("copy" + i));
        }

    }

    //Loan Out a book. Changes based on State
    public Copy RequestLoanBook(Loanee user){
        return currentState.RequestLoanBook(user, this);
    };

    //Return a copy. May change the state.
    public void ReturnCopy(Copy copy){
        copy.setAvailable(true);
        ChangeState(true);
    };

    //Changes the state.
    private void ChangeState(Boolean availableCopies){
        if (availableCopies){
            this.currentState = possibleStates[1];
        }
        else{
            this.currentState = possibleStates[0];
        }
    };


    //Getters and Setters


    public ArrayList<Copy> getCopies() {
        return copies;
    }

    public void setCopyStatus(){

    }

    public LoanState getState() {
        return null;
    }
};



