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
            Stream.of(new Operateur("test1","test1","test1"),
                    new Operateur("test2","test2","test2"))
                            .forEach(
                                    operateur -> {
                                        repo.save(operateur);
                                    }
                            );
            repo.findAll().forEach(System.out::println);
        };
    }
};
