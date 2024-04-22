package com.Backend.PkgAuth.repositories;

import com.Backend.PkgAuth.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUsername(String username);
    Optional<User> findByUsername(String username);
//    boolean existsByEmail(String email);
//    Optional<User> findByEmail(String email);
    //
}
