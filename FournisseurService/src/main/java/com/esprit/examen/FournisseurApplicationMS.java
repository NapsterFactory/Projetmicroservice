package com.esprit.examen;


import com.esprit.examen.entities.DetailFournisseur;
import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.entities.SecteurActivite;
import com.esprit.examen.repositories.DetailFournisseurRepository;
import com.esprit.examen.repositories.FournisseurRepository;
import com.esprit.examen.repositories.SecteurActiviteRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@EnableEurekaClient
public class FournisseurApplicationMS {

    public static void main(String[] args) {
        SpringApplication.run(FournisseurApplicationMS.class, args);
    }

    @Bean
    ApplicationRunner start(
            FournisseurRepository fournisseurRepository,
            DetailFournisseurRepository detailFournisseurRepository,
            SecteurActiviteRepository secteurActiviteRepository) {
        return args -> {

            Fournisseur fournisseur1 = Fournisseur.builder()
                    .code("156")
                    .build();
            fournisseurRepository.save(fournisseur1);
            Fournisseur fournisseur2 = Fournisseur.builder()
                    .code("157")
                    .build();
            fournisseurRepository.save(fournisseur1);

            DetailFournisseur detailFournisseur1 =
                    DetailFournisseur.builder()
                            .email("f2@gmail.com")
                            .adresse("ben arous")
                            .matricule("matricule2")
                            .fournisseur(fournisseur1)
                            .build();

            DetailFournisseur detailFournisseur2 =
                    DetailFournisseur.builder()
                            .email("f3@gmail.com")
                            .adresse("beja")
                            .matricule("matricule3")
                            .fournisseur(fournisseur1)
                            .build();
            detailFournisseurRepository.save(detailFournisseur1);

            Set<Fournisseur> fournisseurs = new HashSet<>();
            fournisseurs.add(fournisseur1);
            fournisseurs.add(fournisseur2);

            SecteurActivite secteurActivite = SecteurActivite.builder()
                    .codeSecteurActivite("produit alimentaire")
                    .libelleSecteurActivite("libelle2")
                    .fournisseurs(fournisseurs)
                    .build();

            secteurActiviteRepository.save(secteurActivite);
        };
    }
}