package com.example.library.models.Impl;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_book")
public class BookImpl implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;
    private String title;
    private String author;

    public BookImpl() {
    }

    public BookImpl(Long code, String title, String author) {
        this.code = code;
        this.title = title;
        this.author = author;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookImpl book = (BookImpl) o;
        return Objects.equals(code, book.code);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(code);
    }
}
