package org.example;

public class PrivateCustomer extends Customer implements Loanee{

    public PrivateCustomer(String username, String ID){
        super(username, ID);
    }


    /*
    A normal user might take out a loaned book and store it, returning it in a week's time.
    This would not permanmently remove the copy from our library
     */

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

    @Override
    public void update(String message){

        String message2 = name + " " + message;
        System.out.println(message2);

    }

}
