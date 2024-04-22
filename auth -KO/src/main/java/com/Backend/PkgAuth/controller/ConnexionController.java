package com.Backend.PkgAuth.controller;

import com.Backend.PkgAuth.dto.ConnexionRequest;
import com.Backend.PkgAuth.dto.ConnexionResponse;
import com.Backend.PkgAuth.dto.LoginResponse;
import com.Backend.PkgAuth.services.jwt.UserServiceIMPL;
import com.Backend.PkgAuth.utils.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin("*")
@RestController
@RequestMapping("/connexion")
public class ConnexionController {
    private final AuthenticationManager authenticationManager;

    private final UserServiceIMPL userServiceIMPL;

    private final JwtUtil jwtUtil;


    @Autowired
    public ConnexionController(AuthenticationManager authenticationManager, UserServiceIMPL userServiceIMPL, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.userServiceIMPL = userServiceIMPL;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping
    public ConnexionResponse login(@RequestBody ConnexionRequest connexionRequest, HttpServletResponse response) throws IOException {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(connexionRequest.getUsername(), connexionRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Incorrect email or password.");
        } catch (DisabledException disabledException) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Customer is not activated");
            return null;
        }
        final UserDetails userDetails = userServiceIMPL.loadUserByUsername(connexionRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails.getUsername());

        return new ConnexionResponse(jwt);
    }
}
