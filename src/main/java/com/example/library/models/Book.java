package com.example.library.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_book")
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;
    private String title;
    private String author;

    public Book() {
    }

    public Book(Long code, String title, String author) {
        this.code = code;
        this.title = title;
        this.author = author;
    }


}
