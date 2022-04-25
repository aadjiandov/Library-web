package com.example.lab2.service;

import com.example.lab2.model.Author;
import com.example.lab2.model.Book;
import com.example.lab2.model.BookDto;
import com.example.lab2.model.Category;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> listAll();
    Optional<Book> findById(Long id);
    Optional<Book> findByName(String name);
    Optional<Book> save(String name, Category category, Author author, Integer numCopies);
    Optional<Book> save(BookDto bookDto);
    Optional<Book> edit(Long id, String name, Category category, Author author, Integer numCopies);
    Optional<Book> edit (Long id, BookDto bookDto);
    void deleteById(Long id);

}
