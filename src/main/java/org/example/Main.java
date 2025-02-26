package org.example;

public class Main {
    public static void main(String[] args) {

        System.out.println("Starting Library System! \n");

        //Create Library. Add Books.
        Library L = new Library();
        L.addBook(new Book("Mistborn", "Brandon Sanderson", 1));
        L.addBook(new Book("The Lord of The Rings: The Two Towers", "J.R.R Tolkien", 0));
        L.addBook(new Book("Flowers For Algernon", "Daniel Keyes", 1));

        //Add Some Clients. Add them to the waiting list
        PrivateCustomer customerOne = new PrivateCustomer("John Doe", "1");
        PrivateCustomer customerTwo = new PrivateCustomer("Jane Doe", "2");
        PrivateCustomer customerThree = new PrivateCustomer("Jaqueline Doe", "3");
        SchoolLibrary customerFour = new SchoolLibrary("Armadale Primary School", "4", "West Lothian");

        //Start editing some copies to trigger the Waiting List.
        //Look in the console to see the clients printing!

        //John loans the 1 copy of "Flowers for Algernon".
        L.loanBook("Flowers For Algernon", customerOne);

        //Jane Also tries to loan "Flowers for Algernon" but there are now no copies left so she is added to the waiting list!
        L.loanBook("Flowers For Algernon", customerTwo);

        //John returns his copy of "Flowers for Algernon". Jane is alerted when this occurs via the waiting list "Notify" method
        L.returnBook("copy0", "Flowers For Algernon", customerOne);








    }
}