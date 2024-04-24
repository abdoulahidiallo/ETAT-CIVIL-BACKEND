package com.Backend.PkgAuth.services;

import com.Backend.PkgAuth.entities.Role;
import com.Backend.PkgAuth.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleServiceIMPL implements RoleService{
    //
    private final RoleRepository roleRepository;

    @Override
    public Long createRole(Role role) {
        return this.roleRepository.save(role).getId();
    }

    @Override
    public List<Role> getAllRoles() {
        return this.roleRepository.findAll();
    }

    @Override
    public Long editRole(Role role, Long id) {
        //
        Optional<Role> acteAMettreAjourOptional = null;

        acteAMettreAjourOptional = this.roleRepository.findById(id);

        if (acteAMettreAjourOptional.isPresent()) {
            Role acteAMettreAjour = acteAMettreAjourOptional.get();
            acteAMettreAjour.setNom(role.getNom());
            acteAMettreAjour.setDescription(role.getDescription());
            //
            return this.roleRepository.save(acteAMettreAjour).getId();
        } else {
            return Long.valueOf(0);
        }
        //
    }

    @Override
    public void deleteRole(Long id) {
        this.roleRepository.deleteById(id);
    }

    @Override
    public Role detailRole(Long id) {
        Optional<Role> acteOptional = this.roleRepository.findById(id);

        if (acteOptional.isEmpty()){
            return null;
        }
        return acteOptional.get();
    }
    //
}
