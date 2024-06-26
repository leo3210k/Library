package com.example.library.services.impl;

import com.example.library.models.Book;
import com.example.library.models.Loan;
import com.example.library.models.Session;
import com.example.library.repositories.BookRepository;
import com.example.library.services.BookService;
import com.example.library.services.exceptions.DatabaseException;
import com.example.library.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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

    public Book updateBook(Long code, Book book) {
        try {
            Book entity = repository.getReferenceById(code);
            updateData(entity, book);
            return repository.save(entity);
        } catch(EntityNotFoundException e) {
//            e.printStackTrace();
            throw new ResourceNotFoundException(code);
        }
    }

    private void updateData(Book entity, Book loan) {
        entity.setCode(loan.getCode());
        entity.setAuthor(loan.getAuthor());
        entity.setTitle(loan.getTitle());
    }

    public void deleteBook(Long code) {
        try {
            repository.deleteById(code);
        } catch(EmptyResultDataAccessException e) {
//          e.printStackTrace();
            throw new ResourceNotFoundException(code);
        } catch(DataIntegrityViolationException e) {
//          e.printStackTrace();
            throw new DatabaseException(e.getMessage());
        }
    }
}
