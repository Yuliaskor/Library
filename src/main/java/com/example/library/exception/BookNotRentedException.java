package com.example.library.exception;

public class BookNotRentedException extends RuntimeException {

    public BookNotRentedException(Integer bookId) {
        super("Book with id " + bookId + " is not rented");
    }
}