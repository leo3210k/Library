package com.example.library.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_session")
public class Session implements Serializable {


    private Long code;
    private String description;
    private String location;






}
