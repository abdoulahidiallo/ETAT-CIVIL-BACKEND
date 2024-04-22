package com.Backend.PkgAuth.services.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

import com.Backend.PkgAuth.repositories.UserRepository;


@Service
public class UserServiceIMPL implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceIMPL(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Write logic to fetch customer from DB
        com.Backend.PkgAuth.entities.User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
        return new User(user.getUsername(), user.getPassword(), Collections.emptyList());
    }

//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        // Write logic to fetch customer from DB
//        com.Backend.PkgAuth.entities.User user = userRepository.findByEmail(email)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
//
//        return new User(user.getEmail(), user.getPassword(), Collections.emptyList());
//    }

}
