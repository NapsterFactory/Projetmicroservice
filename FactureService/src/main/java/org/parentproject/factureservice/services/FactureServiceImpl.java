package org.parentproject.factureservice.services;

import lombok.extern.slf4j.Slf4j;
import org.parentproject.factureservice.entities.Facture;
import org.parentproject.factureservice.repositories.DetailFactureRepository;
import org.parentproject.factureservice.repositories.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
@Transactional
public class FactureServiceImpl implements IFactureService {

    @Autowired
    FactureRepository factureRepository;
    @Autowired
    DetailFactureRepository detailFactureRepository;
    @Autowired
    ReglementServiceImpl reglementService;

    @Override
    public List<Facture> retrieveAllFactures() {
        List<Facture> factures = factureRepository.findAll();
        for (Facture facture : factures) {
            log.info(" facture : " + facture);
        }
        return factures;
    }

    @Override
    public List<Facture> getFacturesByFournisseur(Long idFournisseur) {
        return null;
    }


    public Facture addFacture(Facture f) {
        return factureRepository.save(f);
    }

    @Override
    public void cancelFacture(Long factureId) {
        Facture facture = factureRepository.findById(factureId).orElse(new Facture());
        facture.setArchivee(true);
        factureRepository.save(facture);
    }

    @Override
    public Facture retrieveFacture(Long factureId) {
        Facture facture = factureRepository.findById(factureId).orElse(null);
        log.info("facture :" + facture);
        return facture;
    }

    @Override
    public void assignOperateurToFacture(Long idOperateur, Long idFacture) {
        return;
    }

    @Override
    public float pourcentageRecouvrement(Date startDate, Date endDate) {
        float totalFacturesEntreDeuxDates = factureRepository.getTotalFacturesEntreDeuxDates(startDate, endDate);
        float totalRecouvrementEntreDeuxDates = reglementService.getChiffreAffaireEntreDeuxDate(startDate, endDate);
        float pourcentage = (totalRecouvrementEntreDeuxDates / totalFacturesEntreDeuxDates) * 100;
        return pourcentage;
    }
//
//	@Override
//	public List<Facture> getFacturesByFournisseur(Long idFournisseur) {
//		Fournisseur fournisseur = fournisseurRepository.findById(idFournisseur).orElse(null);
//		return (List<Facture>) fournisseur.getFactures();
//	}
//
//	@Override
//	public void assignOperateurToFacture(Long idOperateur, Long idFacture) {
//		Facture facture = factureRepository.findById(idFacture).orElse(null);
//		Operateur operateur = operateurRepository.findById(idOperateur).orElse(null);
//		operateur.getFactures().add(facture);
//		operateurRepository.save(operateur);
//	}
//private Facture addDetailsFacture(Facture f, Set<DetailFacture> detailsFacture) {
//        float montantFacture = 0;
//        float montantRemise = 0;
//        for (DetailFacture detail : detailsFacture) {
////			Produit produit = produitRepository.findById(detail.getProduit().getIdProduit()).get();
//            float prixTotalDetail = detail.getQteCommandee() * 20;
//            float montantRemiseDetail = (prixTotalDetail * detail.getPourcentageRemise()) / 100;
//            detail.setMontantRemise(montantRemiseDetail);
//            float prixTotalDetailRemise = prixTotalDetail - montantRemiseDetail;
//            detail.setPrixTotalDetail(prixTotalDetailRemise);
//            montantFacture = montantFacture + prixTotalDetailRemise;
//            montantRemise = montantRemise + montantRemiseDetail;
//
//            detailFactureRepository.save(detail);
//        }
//        f.setMontantFacture(montantFacture);
//        f.setMontantRemise(montantRemise);
//        return f;
//    }


}