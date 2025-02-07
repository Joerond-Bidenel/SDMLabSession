package org.example;

public class Copy {

    Book book;
    String copyID;
    private Boolean available = true;
    public Copy(String copyID, Book book){
        this.copyID = copyID;
        this.book = book;
    }

    public String getCopyID() {
        return copyID;
    }

    public void setAvailable() {
        this.available = true;
        this.book.bookReturned();
    }
    public void setUnavailable() {
        this.available = false;
        this.book.bookTaken();
    }

    public Boolean isAvailable() {
        return available;
    }
}
