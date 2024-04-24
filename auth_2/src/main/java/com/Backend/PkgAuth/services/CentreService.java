package com.Backend.PkgAuth.services;

import com.Backend.PkgAuth.entities.Centre;

import java.util.List;

public interface CentreService {
    //
    Long createCentre(Centre centre);
    List<Centre> getAllCentres();
    Long editCentre(Centre centre, Long id);
    void deleteCentre(Long id);
    Centre detailCentre(Long id);
    //
}
