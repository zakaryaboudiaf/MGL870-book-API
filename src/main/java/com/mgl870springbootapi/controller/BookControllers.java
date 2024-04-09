package com.mgl870springbootapi.controller;

import com.mgl870springbootapi.entity.Book;
import com.mgl870springbootapi.repository.BookRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;

@RestController
public class BookControllers {
    private final BookRepository bookRepository;

    public BookControllers(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping(value = "/books", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Book> getBooks() {
        return bookRepository.findAll();
    }

    @GetMapping(value = "/book/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Book getBook(@PathVariable long id){
        return bookRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Invalid ride id %s", id)));
    }

    @PostMapping(value = "/book", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Book createBook(@Valid @RequestBody Book book) {
        return bookRepository.save(book);
    }
}
