package com.financeControl.finance.control.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.financeControl.finance.control.entity.Conta;

import java.io.Serializable;

public class ContaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Double saldo;
    private Double deposito;
    private Double saque;
    @JsonProperty("user")
    private UserDTO userDTO;

    public ContaDTO() {

    }

    public ContaDTO(Long id, Double saldo, Double deposito, Double saque, UserDTO userDTO) {
        this.id = id;
        this.saldo = saldo;
        this.deposito = deposito;
        this.saque = saque;
        this.userDTO = userDTO;
    }

    public ContaDTO(Conta entity) {
        this.id = entity.getId();
        this.saldo = entity.getSaldo();
        this.deposito = entity.getDeposito();
        this.saque = entity.getSaque();
        this.userDTO = new UserDTO(entity.getUser());
    }

    public Long getId() {
        return id;
    }

    public Double getSaldo() {
        return saldo;
    }

    public Double getDeposito() {
        return deposito;
    }

    public Double getSaque() {
        return saque;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }
}
