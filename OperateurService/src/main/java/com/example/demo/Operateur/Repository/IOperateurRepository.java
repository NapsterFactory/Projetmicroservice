package com.example.demo.Operateur.Repository;
import com.example.demo.Operateur.Operateur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IOperateurRepository extends CrudRepository<Operateur, Long> {
}
