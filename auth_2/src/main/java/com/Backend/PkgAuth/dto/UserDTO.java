package com.Backend.PkgAuth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String prenom;
    private String nom;
    private String contact;
    private String service;
    private String role;
    private String email;
    private String username;
    private String password;
}
