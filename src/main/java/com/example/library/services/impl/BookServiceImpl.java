package com.example.library.services.impl;

import com.example.library.models.Book;
import com.example.library.models.Loan;
import com.example.library.models.Session;
import com.example.library.repositories.BookRepository;
import com.example.library.services.BookService;
import com.example.library.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository repository;

    public List<Book> findAll() { return repository.findAll(); }

    public Book findByCode(Long code) {
        Optional<Book> obj = repository.findById(code);
        return obj.orElseThrow(() -> new ResourceNotFoundException(code));
    }

    public Book insertBook(Book book) {
        return repository.save(book);
    }
}
