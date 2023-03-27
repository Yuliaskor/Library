package com.example.library.exception;

public class BookAlreadyRentedException extends RuntimeException {

    public BookAlreadyRentedException() {
        super("Book already rented");
    }
}
