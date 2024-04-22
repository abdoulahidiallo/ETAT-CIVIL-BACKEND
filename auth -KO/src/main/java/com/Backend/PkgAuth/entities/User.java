package com.Backend.PkgAuth.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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

    @Column(name = "prenom", length = 50, nullable = false)
    private String prenom;

    @Column(name = "nom", length = 50, nullable = false)
    private String nom;

    @Column(name = "contact", length = 50, nullable = false)
    private String contact;

//    @Column(name = "position", length = 50, nullable = true)
//    private String position;
//
//    @Column(name = "profile", length = 50, nullable = true)
//    private String profile;

    @Column(name = "username", length = 50, nullable = false)
    private String username;

    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @Column(name="password", length = 100, nullable = false)
    private String password;
    //
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<Role> role;

    //Relation avec Service (ManyToOne): +sieurs utilisateurs avec un meme service
    @ManyToOne(optional = false)
    @JoinColumn(name = "centre_id", nullable = false, referencedColumnName = "id")
    private Centre centre;
}
