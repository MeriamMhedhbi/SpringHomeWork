package com.example.test.controllers;

import com.example.test.entity.Facture;
import com.example.test.services.IFactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facture")
public class FactureController {

    @Autowired
    IFactureService iFactureService;

    @GetMapping("retrieveAllFactures")
    public List<Facture> retrieveAllFactures(){
        return iFactureService.retrieveAllFactures();
    }

    @GetMapping("retrieveFacture/{id}")
    public Facture retrieveFacture(@PathVariable("id") Long id){
        return iFactureService.retrieveFacture(id);
    }

    @GetMapping("getFacturesByClient/{idClient}")
    public List<Facture> getFacturesByClient(@PathVariable("idClient") Long idClient){
        return iFactureService.getFacturesByClient(idClient);
    }

    @PostMapping("cancelFacture/{id}")
    public void cancelFacture(@PathVariable Long id){
        iFactureService.cancelFacture(id);
    }


}
