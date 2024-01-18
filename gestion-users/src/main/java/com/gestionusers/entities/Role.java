package com.gestionusers.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name="roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Role {
    //
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nom_role", length = 50, nullable = false)
    private String nomRole;

    @Column(name = "desc_role", length = 100, nullable = true)
    private String descRole;

    @OneToMany(mappedBy = "role")
    Collection<User> users =  new ArrayList<>();
}
