package com.example.library.controllers;

import com.example.library.models.Loan;
import com.example.library.models.User;
import com.example.library.services.impl.LoanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/loans")
public class LoanController {

    @Autowired
    private LoanServiceImpl service;

    @GetMapping
    public ResponseEntity<List<Loan>> findAll() {
        List<Loan> loans = service.findAll();

        return ResponseEntity.ok().body(loans);
    }

    @GetMapping(value = "/{code}")
    ResponseEntity<Loan> findByEnrollment(@PathVariable Long code) {
        Loan loan = service.findByCode(code);

        return ResponseEntity.ok().body(loan);
    }

    @PostMapping
    public ResponseEntity<Loan>  insert(@RequestBody Loan loan) {
        loan = service.insertLoan(loan);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{code}").buildAndExpand(loan.getCode()).toUri();
        return ResponseEntity.created(uri).body(loan);
    }

    @PutMapping(value = "/{code}")
    ResponseEntity<Loan> update(@PathVariable Long code, @RequestBody Loan loan) {
        loan = service.updateLoan(code, loan);

        return ResponseEntity.ok().body(loan);
    }

    @DeleteMapping(value = "/{code}")
    public ResponseEntity<Void> delete(@PathVariable Long code) {
        service.deleteLoan(code);

        return ResponseEntity.noContent().build();
    }
}
