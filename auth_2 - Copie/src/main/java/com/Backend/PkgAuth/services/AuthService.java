package com.Backend.PkgAuth.services;

import com.Backend.PkgAuth.dto.SignupRequest;
import com.Backend.PkgAuth.entities.User;

public interface AuthService {
    User createUser(SignupRequest signupRequest);
}
