package org.example;

import java.util.ArrayList;

public class WaitingList {

    ArrayList<Loanee> loanees = new ArrayList<>();

    public void subscribe(Loanee l){
        loanees.add(l);
    }

    public void unsubscribe(Loanee l){
        loanees.remove(l);
    }

    public ArrayList<Loanee> getSubscribed(){
        return loanees;
    }

    public void notifySubscribers(String message){

        for(Loanee l : loanees){
            l.update(message);
        }

    }



}
