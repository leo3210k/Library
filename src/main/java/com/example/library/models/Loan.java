package com.example.library.models.Impl;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tb_loan")
public class LoanImpl implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;
    private Date withdraw;
    private Date devolution;

    @ManyToOne
    @JoinColumn(name="user_code")
    private UserImpl user;

    public LoanImpl() {
    }

    public LoanImpl(Long code, Date withdraw, Date devolution, UserImpl user) {
        this.code = code;
        this.withdraw = withdraw;
        this.devolution = devolution;
        this.user = user;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public Date getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(Date withdraw) {
        this.withdraw = withdraw;
    }

    public Date getDevolution() {
        return devolution;
    }

    public void setDevolution(Date devolution) {
        this.devolution = devolution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoanImpl loan = (LoanImpl) o;
        return Objects.equals(code, loan.code);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(code);
    }
}
