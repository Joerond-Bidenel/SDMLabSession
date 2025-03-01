package org.example;

public class Main {
    public static void main(String[] args) {

        System.out.println("Starting Library System!");

        //Create Library. Add Books.
        Library L = new Library();

        Book Mistborn = new Book("Mistborn", "Brandon Sanderson", 1);
        Book FlowersForAlgernon = new Book("Flowers For Algernon", "Daniel Keyes", 1);

        L.addBook(Mistborn);
        L.addBook(FlowersForAlgernon);

        //Add Some Clients. Add them to the waiting list
        PrivateCustomer johnDoe = new PrivateCustomer("John Doe", "1");
        PrivateCustomer janeDoe = new PrivateCustomer("Jane Doe", "2");
        PrivateCustomer jimDoe = new PrivateCustomer("Jim Doe", "3");
        PrivateCustomer jillDoe = new PrivateCustomer("Jill Doe", "4");

        //John loans the 1 copy of "Flowers for Algernon". There are now 0 Left
        L.loanBook("Flowers For Algernon", johnDoe);

        //System.out.println(FlowersForAlgernon.waitingList.getSubscribed().toString());


        //Jane and Jim also try to loan "Flowers for Algernon" but there are now no copies left!
        //We would expect them to be enrolled on the waiting list after this!
        L.loanBook("Flowers For Algernon", janeDoe);
        L.loanBook("Flowers For Algernon", jimDoe);


        //John returns his copy of "Flowers for Algernon".
        //Jane is alerted when this occurs via the waiting list - "Jane Doe Returned" or the like!
        L.returnBook("copy0", "Flowers For Algernon", johnDoe);

        //If Jill is to loan the book before Jim and Jane get a chance to, the waiting list should tell us that
        //there are now no copies left
        L.loanBook("Flowers For Algernon", jillDoe);

    }
}