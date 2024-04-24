package com.Backend.PkgAuth.repositories;

import com.Backend.PkgAuth.entities.Centre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CentreRepository extends JpaRepository<Centre, Long> {
}
