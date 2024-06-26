package com.example.library.services;

import com.example.library.models.Book;
import com.example.library.models.Loan;
import com.example.library.models.User;

import java.util.List;

public interface BookService {
    List<Book> findAll();

    Book findByCode(Long code);

    Book insertBook(Book book);

    Book updateBook(Long code, Book book);

    void deleteBook(Long code);
}
