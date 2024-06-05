package com.example.library.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_user")
public class User  {


    private Long enrollment;

    private String name;
    private String email;
    private String address;
    private String phone;

    public User() {
    }


}
