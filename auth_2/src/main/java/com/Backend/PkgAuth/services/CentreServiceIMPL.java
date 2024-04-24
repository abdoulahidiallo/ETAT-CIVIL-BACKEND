package com.Backend.PkgAuth.services;

import com.Backend.PkgAuth.entities.Centre;
import com.Backend.PkgAuth.repositories.CentreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CentreServiceIMPL implements CentreService {
    //
    private final CentreRepository centreRepository;

    @Override
    public Long createCentre(Centre centre) {
        return this.centreRepository.save(centre).getId();
    }

    @Override
    public List<Centre> getAllCentres() {
        return this.centreRepository.findAll();
    }

    @Override
    public Long editCentre(Centre centre, Long id) {
        //
        Optional<Centre> centreAMettreAjourOptional = null;

        centreAMettreAjourOptional = this.centreRepository.findById(id);

        if (centreAMettreAjourOptional.isPresent()) {
            Centre centreAMettreAjour = centreAMettreAjourOptional.get();
            centreAMettreAjour.setCodeCentre(centre.getCodeCentre());
            centreAMettreAjour.setNomCentre(centre.getNomCentre());
            centreAMettreAjour.setNomMaire(centre.getNomMaire());
            centreAMettreAjour.setStatutMaire(centre.getStatutMaire());
            centreAMettreAjour.setNomOec(centre.getNomOec());
            centreAMettreAjour.setStatutOec(centre.getStatutOec());
            centreAMettreAjour.setRegion(centre.getRegion());
            centreAMettreAjour.setDepartement(centre.getDepartement());
            centreAMettreAjour.setArrondissement(centre.getArrondissement());
            centreAMettreAjour.setCommune(centre.getCommune());
            centreAMettreAjour.setAdresse(centre.getAdresse());
            centreAMettreAjour.setContact(centre.getContact());
            //
            return this.centreRepository.save(centreAMettreAjour).getId();
        } else {
            return Long.valueOf(0);
        }
        //
    }

    @Override
    public void deleteCentre(Long id) {
        this.centreRepository.deleteById(id);
    }

    @Override
    public Centre detailCentre(Long id) {
        Optional<Centre> centreOptional = this.centreRepository.findById(id);

        if (centreOptional.isEmpty()){
            return null;
        }
        return centreOptional.get();
    }
    //
}
