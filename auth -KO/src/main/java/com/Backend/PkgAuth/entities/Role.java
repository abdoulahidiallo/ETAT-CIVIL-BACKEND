package com.Backend.PkgAuth.entities;

import jakarta.persistence.*;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Role {
    //
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 50, nullable = false)
    private String nom;
    @Column(length = 50, nullable = true)
    private String description;
    //
    //Relation avec Utilisateur (@OneToMany): +un role pour +_sieurs utilisateurs, donc une liste d'utilisateurs
    @ManyToMany(mappedBy = "role", cascade = CascadeType.ALL) //
    private List<User> users;
}
