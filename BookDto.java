package com.example.lab2.model;

import lombok.Data;

@Data
public class BookDto {
    private String name;
    private Category category;
    private Author author;
    private Integer availableCopies;

    public BookDto(String name, Category category, Author author, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }

    public BookDto() {}
}
