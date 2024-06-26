package com.example.demo.Operateur.Service;
import com.example.demo.Operateur.IOperateurService;
import com.example.demo.Operateur.Operateur;
import com.example.demo.Operateur.Repository.IOperateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperateurServiceImpl implements IOperateurService {
    @Autowired
    IOperateurRepository candRepo;
    @Override
    public Operateur addOperateur(Operateur o){
        return candRepo.save(o);
    }
    @Override
    public List<Operateur> getOperateurs(){
        return (List<Operateur>) candRepo.findAll();
    }
    @Override
    public Operateur getById(Long Id){
        Operateur o= candRepo.findById(Id).orElse(null);
        return candRepo.findById(Id).orElse(null);
    }
}
