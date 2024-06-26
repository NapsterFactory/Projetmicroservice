package org.parentproject.factureservice;

import org.parentproject.factureservice.entities.DetailFacture;
import org.parentproject.factureservice.entities.Facture;
import org.parentproject.factureservice.entities.Reglement;
import org.parentproject.factureservice.repositories.DetailFactureRepository;
import org.parentproject.factureservice.repositories.FactureRepository;
import org.parentproject.factureservice.repositories.ReglementRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import java.time.Instant;
import java.util.Date;

@SpringBootApplication
@EnableEurekaClient
public class FactureServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FactureServiceApplication.class, args);
    }

    @Bean
    ApplicationRunner start(
            FactureRepository factureRepository,
            DetailFactureRepository detailFactureRepository,
            ReglementRepository reglementRepository) {
        return args -> {

            Facture facture = Facture.builder()
                    .montantFacture(156)
                    .build();
            factureRepository.save(facture);

            DetailFacture detailFacture =
                    DetailFacture.builder()
                            .prixTotalDetail(156)
                            .montantRemise(15)
                            .qteCommandee(20)
                            .facture(facture)
                            .build();
            detailFactureRepository.save(detailFacture);

            Reglement reglement = Reglement.builder()
                    .dateReglement(Date.from(Instant.now()))
                    .payee(false)
                    .montantPaye(0)
                    .montantRestant(156)
                    .facture(facture)
                    .build();
            reglementRepository.save(reglement);
        };
    }
}