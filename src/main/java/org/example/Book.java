package org.example;

import javax.print.attribute.standard.Copies;
import java.util.ArrayList;

public class Book {

    //Variables storing data about a book.
    String title;
    String author;
    Integer noOfCopies;
    LoanState currentState;
    private final LoanState[] possibleStates = {new NoCopiesAvailable(), new CopiesAvailable()};
    ArrayList<Copy> copies = new ArrayList<>();


    /**    Constructor Method. On instantiation, sets book data and creates a number of copy instances for the book
     * @param author Book authour
     * @param title Book title
     * @param NoOfCopies How many copies of the book exist - and should be created in the system
     */
    public Book(String title, String author, Integer NoOfCopies) {

        this.title = title;
        this.author = author;
        this.noOfCopies = NoOfCopies;
        for (int i = 0; i < NoOfCopies; i++){
            ChangeState(true);
            copies.add(new Copy(title + " copy#" + i, this));
        }

    }

    /**
     * Returns a copy of this book. Checks that the copy is valid, then sets it available and increases internal copy count. Possibly changes state if this becomes the only available copy
     * @param copyID The ID of the copy to return
     * @return True if the copy was valid and returned - False if unable to return the copy
     */
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


    /**
     * Invokes State. Gets a copy of the book that can be loaned
     * @return returns an available to loan Copy of the book, or null if none available.
     */
    public String loanThisBook(){
        //get a copy
        return this.currentState.loan(this);
    }

    /**
     * Decrements copy count. Changes state if copy count is 0.
     */
    public void bookTaken(){
        this.noOfCopies -= 1;
        if (noOfCopies == 0){
            ChangeState(false);
        }
    }


    /**
     * Changes the Loanstate, depending on whether there are copies available or not.
     * @param availableCopies True or False whether there are available copies of a book
     */
    private void ChangeState(Boolean availableCopies){
        if (availableCopies){
            this.currentState = possibleStates[1];
        }
        else{
            this.currentState = possibleStates[0];
        }
    };


    /**
     * For every copy of this book, find one that is available to loan.
     * @return an available copy that can be loaned, null otherwise
     */
    public Copy getAvailableCopy(){
        for (Copy copy : copies){
            if (copy.isAvailable()){
                return copy;
            }
        }
        return null;
    }
};



