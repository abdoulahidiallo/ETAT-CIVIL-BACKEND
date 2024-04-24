package com.Backend.PkgAuth.services;

import com.Backend.PkgAuth.entities.Role;

import java.util.List;

public interface RoleService {
    //
    Long createRole(Role role);
    List<Role> getAllRoles();
    Long editRole(Role role, Long id);
    void deleteRole(Long id);
    Role detailRole(Long id);
    //
}
