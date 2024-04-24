package com.Backend.PkgAuth.controller;

import com.Backend.PkgAuth.dto.UserDTO;
import com.Backend.PkgAuth.dto.UserSaveDTO;
import com.Backend.PkgAuth.services.UtilisateurService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserController {
    //
    @Autowired
    private UtilisateurService utilisateurService;
    //
    @PostMapping(path = "/save")
    public String saveService(@RequestBody UserSaveDTO userSaveDTO)
    {
        String id = utilisateurService.addUser(userSaveDTO);
        return id;
    }
    //
    @GetMapping(path = "/listAllUsers")
    public List<UserDTO> readAllService()
    {
        List<UserDTO> allDataUsers = utilisateurService.getAllUsers();
        return allDataUsers;
    }
    //
    @PutMapping(path = "/update")
    public String updateUser(@RequestBody UserDTO userDTO)
    {
        String id = utilisateurService.updateUser(userDTO);
        return id;
    }
    //
    @DeleteMapping(path = "/delete/{id}")
    public String deleteUser(@PathVariable(value = "id") Long id)
    {
        boolean deleteUser = utilisateurService.deleteUser(id);
        return "deleted";
    }
}
