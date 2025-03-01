package org.example;


/**
 * This class represents a copy of a book.
 * It is available when no-one has loaned this copy.
 */
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
    }
    public void setUnavailable() {
        this.available = false;
    }

    public Boolean isAvailable() {
        return available;
    }
}
