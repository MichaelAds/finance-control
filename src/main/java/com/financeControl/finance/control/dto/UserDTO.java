package com.financeControl.finance.control.dto;

import com.financeControl.finance.control.entity.User;


public class UserDTO {
    private Long id;
    private String name;
    private String idade;
    private String email;
    private String phone;
    private String password;

    public UserDTO() {

    }

    public UserDTO(Long id, String name, String idade, String email, String phone, String password) {
        this.id = id;
        this.name = name;
        this.idade = idade;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public UserDTO(User entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.idade = entity.getIdade();
        this.email = entity.getEmail();
        this.phone = entity.getPhone();
        this.password = entity.getPassword();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIdade() {
        return idade;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

}

