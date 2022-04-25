package com.example.lab2.exceptions;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(Long id) {
        super(String.format("The book with id " + id + " was not found"));
    }
}
