package com.example.demo.Operateur.Controller;
import com.example.demo.Operateur.IOperateurService;
import com.example.demo.Operateur.Operateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping(value ="API/GestionOperateur")
public class OperateurController {
    @Autowired
    IOperateurService canService;
    @PostMapping("/AddOperateur")
    public Operateur addOperateur(@RequestBody Operateur o){
        return canService.addOperateur(o);
    }
    @GetMapping("/getOne/{id}")
    public Operateur getOne(@PathVariable("id") Long id){
        return canService.getById(id);
    }
    @GetMapping("/getAll")
    public List<Operateur> getAll(){
        return canService.getOperateurs();
    }
}