package com.example.library.controllers;

import com.example.library.models.User;
import com.example.library.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

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

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User user) {
        user = service.insertUser(user);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{enrollment}").buildAndExpand(user.getEnrollment()).toUri();
        return ResponseEntity.created(uri).body(user);
    }

    @PutMapping(value = "/{enrollment}")
    ResponseEntity<User> update(@PathVariable Long enrollment, @RequestBody User user) {
        user = service.updateUser(enrollment, user);

        return ResponseEntity.ok().body(user);
    }

    // Se o usuário tiver pedidos, será dado código 500 Internal Server Error
    // para não perder a integridade do banco de dados
    @DeleteMapping(value = "/{enrollment}")
    public ResponseEntity<Void> delete(@PathVariable Long enrollment) {
        service.deleteUser(enrollment);

        // Código 204 = Resposta que não possui conteúdo
        return ResponseEntity.noContent().build();
    }
}
