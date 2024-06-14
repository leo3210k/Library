package com.example.library.services.Impl;

import com.example.library.models.Loan;
import com.example.library.repositories.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanService {

    @Autowired
    private LoanRepository repository;

    public List<Loan> findAll() { return repository.findAll(); }

    public Loan findByCode(Long code) {
        Optional<Loan> obj = repository.findById(code);
        return obj.get();
    }
}
