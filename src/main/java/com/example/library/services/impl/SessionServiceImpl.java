package com.example.library.services.impl;

import com.example.library.models.Book;
import com.example.library.models.Session;
import com.example.library.models.User;
import com.example.library.repositories.SessionRepository;
import com.example.library.services.SessionService;
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

    public Session updateSession(Long code, Session session) {
        try {
            Session entity = repository.getReferenceById(code);
            updateData(entity, session);
            return repository.save(entity);
        } catch(EntityNotFoundException e) {
//            e.printStackTrace();
            throw new ResourceNotFoundException(code);
        }
    }

    private void updateData(Session entity, Session loan) {
        entity.setCode(loan.getCode());
        entity.setDescription(loan.getDescription());
        entity.setLocation(loan.getLocation());
    }

    public void deleteSession(Long code) {
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
