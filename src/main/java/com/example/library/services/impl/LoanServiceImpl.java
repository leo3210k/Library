package com.example.library.services.impl;

import com.example.library.models.Loan;
import com.example.library.models.Session;
import com.example.library.models.User;
import com.example.library.repositories.LoanRepository;
import com.example.library.services.LoanService;
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
public class LoanServiceImpl implements LoanService {

    @Autowired
    private LoanRepository repository;

    public List<Loan> findAll() { return repository.findAll(); }

    public Loan findByCode(Long code) {
        Optional<Loan> obj = repository.findById(code);
        return obj.orElseThrow(() -> new ResourceNotFoundException(code));
    }

    public Loan insertLoan(Loan loan) {
        return repository.save(loan);
    }

    public Loan updateLoan(Long code, Loan loan) {
        try {
            Loan entity = repository.getReferenceById(code);
            updateData(entity, loan);
            return repository.save(entity);
        } catch(EntityNotFoundException e) {
//            e.printStackTrace();
            throw new ResourceNotFoundException(code);
        }
    }

    private void updateData(Loan entity, Loan loan) {
        entity.setCode(loan.getCode());
        entity.setWithdraw(loan.getWithdraw());
        entity.setDevolution(loan.getDevolution());
    }


    public void deleteLoan(Long code) {
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
