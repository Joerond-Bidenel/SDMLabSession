package org.example;

import java.util.ArrayList;

public class WaitingList {

    //List of people on the waiting List for a specific Book
    ArrayList<Loanee> subscribers = new ArrayList<>();

    //Add a subscriber to the list
    public void subscribe(Loanee X){
        subscribers.add(X);
    };



    //Remove a subscriber from the list
    public void unsubscribe(Loanee X){
        subscribers.remove(X);
    };


    //Alert all subscribers that something has happened
    public void notifySubscribers(String message){

        for (Loanee loanee : subscribers) {
            loanee.update(message);
        }

    };

}
