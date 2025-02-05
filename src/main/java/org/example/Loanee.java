package org.example;

import java.sql.SQLOutput;

public interface Loanee {

    String username = null;

    default void update(String message){
        System.out.println("User "+ username + " has received the message!");
        System.out.println("Message Reads: " + message);
    };


}
