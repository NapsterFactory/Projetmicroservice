package com.example.demo;
import com.example.demo.Operateur.Operateur;
import com.example.demo.Operateur.Repository.IOperateurRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.stream.Stream;
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    @Bean
    ApplicationRunner start(IOperateurRepository repo){
        return args -> {
            Stream.of(new Operateur("Rihab","Idoudi","aa1234"),
                    new Operateur("toto","titi","test2333"))
                            .forEach(
                                    operateur -> {
                                        repo.save(operateur);
                                    }
                            );
            repo.findAll().forEach(System.out::println);
        };
    }
};
