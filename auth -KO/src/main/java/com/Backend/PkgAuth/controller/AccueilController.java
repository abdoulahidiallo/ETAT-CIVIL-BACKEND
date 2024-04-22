package com.Backend.PkgAuth.controller;

import com.Backend.PkgAuth.dto.HelloResponse;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class AccueilController {

    @GetMapping("/accueil")
    public HelloResponse hello(){
        return new HelloResponse("Hello from Authorized API request.");
    }

}
