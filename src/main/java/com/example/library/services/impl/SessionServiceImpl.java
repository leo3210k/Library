package com.example.library.services.impl;

import com.example.library.models.Book;
import com.example.library.models.Session;
import com.example.library.models.User;
import com.example.library.repositories.SessionRepository;
import com.example.library.services.SessionService;
import com.example.library.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SessionServiceImpl implements SessionService {

    @Autowired
    private SessionRepository repository;

    public List<Session> findAll() { return repository.findAll(); }

    public Session findByCode(Long code) {
        Optional<Session> obj = repository.findById(code);
        return obj.orElseThrow(() -> new ResourceNotFoundException(code));
    }

    public Session insertSession(Session session) {
        return repository.save(session);
    }
}
