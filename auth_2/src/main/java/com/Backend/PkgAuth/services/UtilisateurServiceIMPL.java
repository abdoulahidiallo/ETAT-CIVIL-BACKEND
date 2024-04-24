package com.Backend.PkgAuth.services;

import com.Backend.PkgAuth.dto.UserDTO;
import com.Backend.PkgAuth.dto.UserSaveDTO;
import com.Backend.PkgAuth.entities.User;
import com.Backend.PkgAuth.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.apache.coyote.http11.Constants.a;

@Service
public class UtilisateurServiceIMPL implements UtilisateurService{

    @Autowired
    UserRepository userRepository;

    @Override
    public String addUser(UserSaveDTO userSaveDTO) {
        //
        User user = new User(
                //
                userSaveDTO.getPrenom(),
                userSaveDTO.getNom(),
                userSaveDTO.getContact(),
                userSaveDTO.getService(),
                userSaveDTO.getRole(),
                userSaveDTO.getEmail(),
                userSaveDTO.getUsername(),
                userSaveDTO.getPassword()
        );
        userRepository.save(user);
        return user.getUsername();
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> getListUsers = userRepository.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();
        UserDTO userDTO = null;
        for (User u : getListUsers) {
            userDTO = new UserDTO(
                    u.getId(),
                    u.getPrenom(),
                    u.getNom(),
                    u.getContact(),
                    u.getService(),
                    u.getRole(),
                    u.getEmail(),
                    u.getUsername(),
                    u.getPassword()
            );
            userDTOList.add(userDTO);
        }
        return userDTOList;
    }

    @Override
    public String updateUser(UserDTO userDTO) {
        if(userRepository.existsById(userDTO.getId()))
        {
            User user = userRepository.getReferenceById(userDTO.getId());
            user.setPrenom(userDTO.getPrenom());
            user.setNom(userDTO.getNom());
            user.setContact(userDTO.getContact());
            user.setService(userDTO.getService());
            user.setRole(userDTO.getRole());
            user.setEmail(userDTO.getEmail());
            user.setUsername(userDTO.getUsername());
            user.setPassword(userDTO.getPassword());
            userRepository.save(user);
        }
        else{
            System.out.println("UTILISATEUR NON DISPONIBLE !!!");
        }
        return null;
    }

    @Override
    public boolean deleteUser(Long id) {
        if(userRepository.existsById(id))
        {
            userRepository.deleteById(id);
        }
        else
        {
            System.out.println("UTILISATEUR NON DISPONIBLE !");
        }
        return true;
    }

    @Override
    public User getOneUser(Long id) {
        return null;
    }
}
