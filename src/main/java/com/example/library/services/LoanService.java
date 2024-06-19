package com.example.library.services;

import com.example.library.models.Book;
import com.example.library.models.Loan;
import com.example.library.models.Session;

import java.util.List;

public interface LoanService {
    List<Loan> findAll();

    Loan findByCode(Long code);

    Loan insertLoan(Loan loan);

    Loan updateLoan(Long code, Loan loan);
}
