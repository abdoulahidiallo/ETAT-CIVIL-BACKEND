package com.Backend.PkgAuth.dto;

import lombok.*;


@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSaveDTO {
    private String prenom;
    private String nom;
    private String contact;
    private String service;
    private String role;
    private String email;
    private String username;
    private String password;

    //
    
}
