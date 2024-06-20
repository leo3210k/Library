package com.example.library.controllers;

import com.example.library.models.Session;
import com.example.library.models.User;
import com.example.library.services.impl.SessionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/sessions")
public class SessionController {

    @Autowired
    private SessionServiceImpl service;

    @GetMapping
    public ResponseEntity<List<Session>> findAll() {
        List<Session> sessions = service.findAll();

        return ResponseEntity.ok().body(sessions);
    }

    @GetMapping(value = "/{code}")
    ResponseEntity<Session> findByEnrollment(@PathVariable Long code) {
        Session session = service.findByCode(code);

        return ResponseEntity.ok().body(session);
    }

    @PostMapping
    public ResponseEntity<Session>  insert(@RequestBody Session session) {
        session = service.insertSession(session);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{code}").buildAndExpand(session.getCode()).toUri();
        return ResponseEntity.created(uri).body(session);
    }

    @PutMapping(value = "/{code}")
    ResponseEntity<Session> update(@PathVariable Long code, @RequestBody Session session) {
        session = service.updateSession(code, session);

        return ResponseEntity.ok().body(session);
    }
}
