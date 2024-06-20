package com.example.library.controllers;

import com.example.library.models.Book;
import com.example.library.models.User;
import com.example.library.services.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/books")
public class BookController {

    @Autowired
    private BookServiceImpl service;

    @GetMapping
    public ResponseEntity<List<Book>> findAll() {
        List<Book> books = service.findAll();

        return ResponseEntity.ok().body(books);
    }

    @GetMapping(value = "/{code}")
    ResponseEntity<Book> findByEnrollment(@PathVariable Long code) {
        Book book = service.findByCode(code);

        return ResponseEntity.ok().body(book);
    }

    @PostMapping
    public ResponseEntity<Book>  insert(@RequestBody Book book) {
        book = service.insertBook(book);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{code}").buildAndExpand(book.getCode()).toUri();
        return ResponseEntity.created(uri).body(book);
    }

    @PutMapping(value = "/{code}")
    ResponseEntity<Book> update(@PathVariable Long code, @RequestBody Book book) {
        book = service.updateBook(code, book);

        return ResponseEntity.ok().body(book);
    }

    @DeleteMapping(value = "/{code}")
    public ResponseEntity<Void> delete(@PathVariable Long code) {
        service.deleteBook(code);

        return ResponseEntity.noContent().build();
    }
}
