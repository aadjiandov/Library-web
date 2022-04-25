package com.example.lab2.exceptions;

public class BookAlreadyExistsException extends RuntimeException{
    public BookAlreadyExistsException(String message) {
        super("A book with the name " + message + " already exists");
    }
}
