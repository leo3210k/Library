package com.example.library.services;

import com.example.library.models.Session;
import com.example.library.models.User;

import java.util.List;

public interface SessionService {
    List<Session> findAll();

    Session findByCode(Long code);

    Session insertSession(Session session);
}
