package com.Backend.PkgAuth.services;
import com.Backend.PkgAuth.dto.SignupRequest;
import com.Backend.PkgAuth.entities.User;
import com.Backend.PkgAuth.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;


@Service
public class AuthServiceImpl implements AuthService{

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public User createUser(SignupRequest signupRequest) {
        //Check if customer already exist
        if (userRepository.existsByUsername(signupRequest.getUsername())) {
            return null;
        }

        User user = new User();
        BeanUtils.copyProperties(signupRequest,user);

        //Hash the password before saving
        String hashPassword = passwordEncoder.encode(signupRequest.getPassword());
        user.setPassword(hashPassword);
        User createdUser = userRepository.save(user);
        user.setId(createdUser.getId());
        return user;
    }

}
