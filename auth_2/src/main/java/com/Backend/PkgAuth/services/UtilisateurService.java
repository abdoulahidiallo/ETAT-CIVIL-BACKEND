package com.Backend.PkgAuth.services;

import com.Backend.PkgAuth.dto.UserDTO;
import com.Backend.PkgAuth.dto.UserSaveDTO;
import com.Backend.PkgAuth.entities.Role;
import com.Backend.PkgAuth.entities.User;

import java.util.List;

public interface UtilisateurService {

    String addUser(UserSaveDTO userSaveDTO);

    List<UserDTO> getAllUsers();
    //
    String updateUser(UserDTO userDTO);
    //
    boolean deleteUser(Long id);
    //
    User getOneUser(Long id);

}
