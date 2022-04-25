package com.example.lab2.service.impl;

import com.example.lab2.exceptions.BookAlreadyExistsException;
import com.example.lab2.exceptions.BookNotFoundException;
import com.example.lab2.model.Author;
import com.example.lab2.model.Book;
import com.example.lab2.model.BookDto;
import com.example.lab2.model.Category;
import com.example.lab2.repository.BookRepository;
import com.example.lab2.service.BookService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> listAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Optional<Book> findByName(String name) {
        return bookRepository.findByName(name);
    }

    @Override
    @Transactional
    public Optional<Book> save(String name, Category category, Author author, Integer numCopies) {
        List<Book> listBooks = this.listAll();
        boolean contains = false;
        for(Book book : listBooks){
            if (book.getName().equals(name)){
                contains = true;
            }
        }
        if (contains){
            throw new BookAlreadyExistsException(name);
        }
        else{
            Book newBook = new Book(name, category, author, numCopies);
            bookRepository.save(newBook);
            return Optional.of(newBook);
        }
    }

    @Override
    public Optional<Book> save(BookDto bookDto) {
        List<Book> listBooks = this.listAll();
        boolean contains = false;
        for(Book book : listBooks){
            if (book.getName().equals(bookDto.getName())){
                contains = true;
            }
        }
        if (contains){
            throw new BookAlreadyExistsException(bookDto.getName());
        }
        else{
            Book newBook = new Book(bookDto.getName(), bookDto.getCategory(), bookDto.getAuthor(), bookDto.getAvailableCopies());
            bookRepository.save(newBook);
            return Optional.of(newBook);
        }
    }

    @Override
    public Optional<Book> edit(Long id, String name, Category category, Author author, Integer numCopies) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));

        book.setName(name);
        book.setCategory(category);
        book.setAuthor(author);
        book.setAvailableCopies(numCopies);

        bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public Optional<Book> edit(Long id, BookDto bookDto) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));

        book.setName(bookDto.getName());
        book.setCategory(bookDto.getCategory());
        book.setAuthor(bookDto.getAuthor());
        book.setAvailableCopies(bookDto.getAvailableCopies());

        bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}
