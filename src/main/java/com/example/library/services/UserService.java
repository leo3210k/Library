package com.example.library.services;

import com.example.library.models.User;
import com.example.library.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() { return repository.findAll(); }

    public User findByEnrollment(Long enrollment) {
        Optional<User> obj = repository.findById(enrollment);
        return obj.get();
    }
}
