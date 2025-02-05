package org.example;

import java.util.ArrayList;

public class WaitingList {

    //List of people on the waiting List for a specific Book
    ArrayList<Loanee> subscribers = new ArrayList<>();

    //Add a subscriber to the list
    public void Subscribe(Loanee X){
        subscribers.add(X);
    };



    //Remove a subscriber from the list
    public void Unsubscribe(Loanee X){
        subscribers.remove(X);
    };


    //Alert all subscribers that something has happened
    public void Notify(Book book, int copies){

        String message = "The book " + book + " has " + copies + " copies available. Contact or visit the library to take it out.";

        for (Loanee loanee : subscribers) {
            loanee.update(message);
        }

    };

}
