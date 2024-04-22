package com.Backend.PkgAuth.controller;

import com.Backend.PkgAuth.dto.RegisterRequest;
import com.Backend.PkgAuth.dto.SignupRequest;
import com.Backend.PkgAuth.entities.User;
import com.Backend.PkgAuth.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("*")
@RestController
@RequestMapping("/register")
public class RegisterController {

    private final AuthService authService;

    @Autowired
    public RegisterController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    public ResponseEntity<?> signupUser(@RequestBody RegisterRequest registerRequest) {
        User createdUser = authService.createUser(registerRequest);
        if (createdUser != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create new user");
        }
    }

}
