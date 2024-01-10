package com.financeControl.finance.control.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_conta")
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double saldo;
    private Double deposito;
    private Double saque;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Conta() {

    }

    public Conta(Long id, Double saldo, Double deposito, Double saque) {
        this.id = id;
        this.saldo = saldo;
        this.deposito = deposito;
        this.saque = saque;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Double getDeposito() {
        return deposito;
    }

    public void setDeposito(Double deposito) {
        this.deposito = deposito;
    }

    public Double getSaque() {
        return saque;
    }

    public void setSaque(Double saque) {
        this.saque = saque;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
