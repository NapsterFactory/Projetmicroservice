package com.example.demo.Operateur;
import java.util.List;
public interface IOperateurService {
    public Operateur addOperateur(Operateur o);
    public List<Operateur> getOperateurs ();
    public Operateur getById(Long Id);
}
