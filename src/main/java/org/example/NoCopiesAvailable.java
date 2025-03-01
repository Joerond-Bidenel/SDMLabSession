package org.example;

public class NoCopiesAvailable implements LoanState{

    /**
     *What book does if there are no copies available when we try to loan a book
     * @param book the book instance.
     * @return null - we can't loan a book
     */
    @Override
    public String loan(Book book){
        return null;
    }
}
