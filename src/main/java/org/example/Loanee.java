package org.example;

public interface Loanee {
    public default void update(String message){
        System.out.println(message);;
    }

}
