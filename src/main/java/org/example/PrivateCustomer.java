package org.example;

import java.util.ArrayList;

/**
 * A private customer - that is, normal people loaning books.
 * A normal user might take out a loaned book and store it, returning it in a week's time.
 */
public class PrivateCustomer extends Customer{

    public PrivateCustomer(String username, String ID){
        super(username, ID);
    }



    //Take out a copy. Store the copy in the internal list.
    @Override
    public boolean takeBook(String copyID){
        loaned.add(copyID);
        return true;
    }

    @Override
    public boolean returnBook(String copyID){
        if (loaned.contains(copyID)){
            loaned.remove(copyID);
            return true;
        }
        else{
            return false;
        }
    }

}
