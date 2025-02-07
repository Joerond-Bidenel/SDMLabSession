package org.example;

public class SchoolLibrary extends Customer implements Loanee{

    String Location = "";


    public SchoolLibrary(String name, String ID, String Location){

        super(name, ID);
        this.Location = Location;

    }

    /*
    A local library might not loan a book, but request a transfer - for example if they have no copies of a popular book, but
    another library has 10 copies.
    This might mean the book's copy is permanently removed from our library.
 */
    @Override
    public boolean takeBook(Copy c){
        //Vague and unspecified logic. Maybe they set up shipping cost etc.
        return false;
    }

    @Override
    public boolean returnBook(Copy c){
        //Transfer the other way. Invoke library and add a new copy of the book if it exists etc
        return false;
    }

    @Override
    public void update(String message){
        System.out.println(this.name + " has received the message!");
        System.out.println("Message Reads: " + message);
        System.out.println("/n");
    }

}
