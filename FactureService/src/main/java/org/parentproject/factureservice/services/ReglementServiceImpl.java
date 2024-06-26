package org.parentproject.factureservice.services;

import org.parentproject.factureservice.entities.Reglement;
import org.parentproject.factureservice.repositories.FactureRepository;
import org.parentproject.factureservice.repositories.ReglementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReglementServiceImpl implements IReglementService {

    @Autowired
    FactureRepository factureRepository;
    @Autowired
    ReglementRepository reglementRepository;

    @Override
    public List<Reglement> retrieveAllReglements() {
        return (List<Reglement>) reglementRepository.findAll();
    }

    @Override
    public Reglement addReglement(Reglement r) {
        reglementRepository.save(r);
        return r;
    }

    @Override
    public Reglement retrieveReglement(Long id) {
        Reglement reglement = reglementRepository.findById(id).orElse(null);
        return reglement;
    }

    @Override
    public List<Reglement> retrieveReglementByFacture(Long idFacture) {
        List<Reglement> reglements = reglementRepository.retrieveReglementByFacture(idFacture);
        return reglements;
    }

    @Override
    public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate) {
        return reglementRepository.getChiffreAffaireEntreDeuxDate(startDate, endDate);
    }

}
