package com.Backend.PkgAuth.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Centre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 5, nullable = false)
    private String codeCentre;
    @Column(length = 50, nullable = false)
    private String nomCentre;
    @Column(length = 50, nullable = false)
    private String nomMaire;
    @Column(length = 20, nullable = false)
    private String statutMaire;
    @Column(length = 50, nullable = false)
    private String nomOec;
    @Column(length = 20, nullable = false)
    private String statutOec;

    @Column(length = 50, nullable = true)
    private String region;
    @Column(length = 50, nullable = true)
    private String departement;
    @Column(length = 50, nullable = true)
    private String arrondissement;
    @Column(length = 50, nullable = true)
    private String commune;
    @Column(length = 50, nullable = true)
    private String contact;
    @Column(length = 50, nullable = true)
    private String adresse;

    //Relation avec Utilisateur (@OneToMany): +un service pour +_sieurs utilisateurs, donc une liste d'utilisateurs
//    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL) //
//    private List<User> users;

    @OneToMany(mappedBy = "centre", cascade = CascadeType.ALL) //
    private List<User> users;
}
