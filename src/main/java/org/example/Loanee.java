package org.example;

import java.sql.SQLOutput;

public interface Loanee {



    default void update(String message){
        System.out.println("User has received the message!");
        System.out.println("Message Reads: " + message);
    };


}
