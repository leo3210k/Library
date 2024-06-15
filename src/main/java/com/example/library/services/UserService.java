package com.example.library.services;

import com.example.library.models.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findByEnrollment(Long enrollment);

    User insertUser(User user);

    User update(Long enrollment, User user);
}
