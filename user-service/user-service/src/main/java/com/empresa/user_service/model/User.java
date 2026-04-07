package com.empresa.user_service.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class User {
    private Long id;
    private String nombre;
    private String email;
    private String password;

    public User() {
        
    }
    public User(Long id, String nombre, String email, String password) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
    }
}