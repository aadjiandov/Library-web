package com.example.lab2.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Category category;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Author author;

    private Integer availableCopies;

    public Book(String name, Category category, Author author, Integer numCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = numCopies;
    }

    public Book() {

    }
}
