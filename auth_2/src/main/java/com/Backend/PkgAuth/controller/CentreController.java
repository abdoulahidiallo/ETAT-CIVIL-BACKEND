package com.Backend.PkgAuth.controller;

import com.Backend.PkgAuth.entities.Centre;
import com.Backend.PkgAuth.services.CentreService;
import com.Backend.PkgAuth.services.CentreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/centres")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CentreController {
    private final CentreService centreService;

    @GetMapping("")
    ResponseEntity<List<Centre>> getAllCentres() {
        return ResponseEntity.ok(this.centreService.getAllCentres());
    }

    @GetMapping("/detail/{id}")
    ResponseEntity<Centre> getCentreById(@PathVariable("id") long id) {
        return ResponseEntity.ok(this.centreService.detailCentre(id));
    }

    @PostMapping("/save")
    ResponseEntity<Long> saveCentre(@RequestBody @Validated Centre role) {
        return ResponseEntity.ok(this.centreService.createCentre(role));
    }

    @PutMapping("/update/{id}")
    ResponseEntity<Long> updateCentre(@PathVariable("id") long id, @RequestBody @Validated Centre role) {
        return ResponseEntity.ok(centreService.editCentre(role, id));
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<Void> deleteCentre(@PathVariable("id") long id) {
        this.centreService.deleteCentre(id);
        return ResponseEntity.accepted().build();
    }
}
