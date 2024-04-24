package com.Backend.PkgAuth.controller;

import com.Backend.PkgAuth.services.RoleService;
import com.Backend.PkgAuth.entities.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
@CrossOrigin("*")
public class RoleController {

    private final RoleService roleService;

    @GetMapping("")
    ResponseEntity<List<Role>> getAllRoles() {
        return ResponseEntity.ok(this.roleService.getAllRoles());
    }

    @GetMapping("/detail/{id}")
    ResponseEntity<Role> getRoleById(@PathVariable("id") long id) {
        return ResponseEntity.ok(this.roleService.detailRole(id));
    }

    @PostMapping("/save")
    ResponseEntity<Long> saveRole(@RequestBody @Validated Role role) {
        return ResponseEntity.ok(this.roleService.createRole(role));
    }

    @PutMapping("/update/{id}")
    ResponseEntity<Long> updateRole(@PathVariable("id") long id, @RequestBody @Validated Role role) {
        return ResponseEntity.ok(roleService.editRole(role, id));
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<Void> deleteRole(@PathVariable("id") long id) {
        this.roleService.deleteRole(id);
        return ResponseEntity.accepted().build();
    }
}
