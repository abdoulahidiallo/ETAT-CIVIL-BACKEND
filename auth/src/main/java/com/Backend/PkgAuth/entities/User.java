package com.Backend.PkgAuth.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    //
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 50)
    private String name;

//    @Column(name = "prenom", length = 50)
//    private String prenom;
//
//    @Column(name = "nom", length = 50)
//    private String nom;

    @Column(name = "contact", length = 50, nullable = true)
    private String contact;

    @Column(name = "service", length = 50, nullable = true)
    private String service;

    @Column(name = "role", length = 20, nullable = true)
    private String role;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "username", length = 50)
    private String username;

    @Column(name = "password", length = 100)
    private String password;
}
