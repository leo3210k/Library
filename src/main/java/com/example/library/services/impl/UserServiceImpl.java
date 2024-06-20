package com.example.library.services.impl;

import com.example.library.models.User;
import com.example.library.repositories.UserRepository;
import com.example.library.services.UserService;
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
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() { return repository.findAll(); }

    public User findByEnrollment(Long enrollment) {
        Optional<User> obj = repository.findById(enrollment);
        return obj.orElseThrow(() -> new ResourceNotFoundException(enrollment));
    }

    public User insertUser(User user) {
        return repository.save(user);
    }

    public User updateUser(Long enrollment, User user) {
        try {
            User entity = repository.getReferenceById(enrollment);
            updateData(entity, user);
            return repository.save(entity);
        } catch(EntityNotFoundException e) {
//            e.printStackTrace();
            throw new ResourceNotFoundException(enrollment);
        }
    }

    public void deleteUser(Long enrollment) {
        try {
            repository.deleteById(enrollment);
        } catch(EmptyResultDataAccessException e) {
//          e.printStackTrace();
            throw new ResourceNotFoundException(enrollment);
        } catch(DataIntegrityViolationException e) {
//          e.printStackTrace();
            throw new DatabaseException(e.getMessage());
        }
    }

    private void updateData(User entity, User user) {
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPhone(user.getPhone());
        entity.setAddress(user.getAddress());
    }
}
