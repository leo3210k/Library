package com.example.library.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long enrollment;

    private String name;
    private String email;
    private String address;
    private String phone;

    public User() {
    }

    public User(Long enrollment, String name, String email, String address, String phone) {
        this.enrollment = enrollment;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }


}
