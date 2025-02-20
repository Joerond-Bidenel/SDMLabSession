package org.example;

import javax.print.attribute.standard.Copies;
import java.util.ArrayList;

public class Book {

    String title;
    String author;
    Integer noOfCopies;
    LoanState currentState;
    private final LoanState[] possibleStates = {new NoCopiesAvailable(), new CopiesAvailable()};
    ArrayList<Copy> copies = new ArrayList<>();


    //Constructor Method
    public Book(String title, String author, Integer NoOfCopies) {

        this.title = title;
        this.author = author;
        this.noOfCopies = NoOfCopies;
        for (int i = 0; i < NoOfCopies; i++){
            ChangeState(true);
            copies.add(new Copy(title + " copy#" + i, this));
        }

    }

    public boolean bookReturned(String copyID){

        //Set the copy available if it exists and has been taken out already
        boolean found = false;
        for(Copy c : copies){
            if (c.copyID.equals(copyID) || !c.isAvailable()){
                c.setAvailable();
                found = true;
            }
        }
        if (!found){
            return false;
        }

        if (this.noOfCopies == 0){
            ChangeState(true);
        }

        this.noOfCopies += 1;
        return true;
    }


    //Get a book copy to loan to a customer
    public String loanThisBook(){
        //get a copy
        return this.currentState.loan(this);
    }

    public void bookTaken(){
        this.noOfCopies -= 1;
        if (noOfCopies == 0){
            ChangeState(false);
        }
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
                return copy;
            }
        }
        return null;
    }
};



