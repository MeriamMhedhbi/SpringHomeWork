package com.example.test.controllers;

import com.example.test.entity.Produit;
import com.example.test.entity.Stock;
import com.example.test.services.IProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/produit")
public class ProduitController {
    @Autowired
    IProduitService iProduitService;

    @GetMapping("retrieveAllProduits")
    public List<Produit> retrieveAllProduits(){
        return iProduitService.retrieveAllProduits();
    }

    @PostMapping("addProduit/{idRayon}/{idStock}")
    public Produit addProduit(@RequestBody Produit p, @PathVariable Long idRayon, @PathVariable Long idStock){
        return  iProduitService.addProduit(p,idRayon,idStock);
    }

    @GetMapping("retrieveProduit/{id}")
    public Produit retrieveProduit(@PathVariable("id") Long id){
        return iProduitService.retrieveProduit(id);
    }

    @PostMapping("assignFournisseurToProduit/{fournisseurId}/{produitId}")
    void assignFournisseurToProduit(@PathVariable("fournisseurId") Long fournisseurId,@PathVariable("produitId") Long produitId){
        iProduitService.assignFournisseurToProduit(fournisseurId,produitId);
    }

    @PostMapping("getRevenuBrutProduit/{idProduit}/{startDate}/{endDate}")
    float getRevenuBrutProduit(@PathVariable("idProduit") Long idProduit, @PathVariable("startDate") Date startDate, @PathVariable("endDate") Date endDate){
        return iProduitService.getRevenuBrutProduit(idProduit,startDate,endDate);
    }
}
