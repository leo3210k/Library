package com.example.library.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tb_loan")
public class Loan {
    private Long code;
    private Date withdraw;
    private Date devolution;


}
