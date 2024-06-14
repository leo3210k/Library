package com.example.library.controllers;

import com.example.library.models.User;
import com.example.library.services.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class SessionController {

    @Autowired
    private UserServiceImpl service;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> users = service.findAll();

        return ResponseEntity.ok().body(users);
    }

    @GetMapping(value = "/{enrollment}")
    ResponseEntity<User> findByEnrollment(@PathVariable Long enrollment) {
        User user = service.findByEnrollment(enrollment);

        return ResponseEntity.ok().body(user);
    }
}
