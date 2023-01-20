package com.garofalo.sportyshoes_ecommerce.entity;

import jakarta.persistence.*;

@Entity
public class UserEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false, name = "id")
    private Long id;

    @Column
    private String name;

    @Column
    private String email;

    public UserEntity() {
    }

    public UserEntity(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public UserEntity(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
