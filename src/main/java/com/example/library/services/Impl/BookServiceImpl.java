package com.example.library.services.Impl;

import com.example.library.models.Book;
import com.example.library.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public List<Book> findAll() { return repository.findAll(); }

    public Book findByCode(Long code) {
        Optional<Book> obj = repository.findById(code);
        return obj.get();
    }
}
