package com.example.test.services;

import com.example.test.entity.Produit;

import java.util.Date;
import java.util.List;

public interface IProduitService {

    List<Produit> retrieveAllProduits();

    Produit addProduit(Produit p, Long idRayon, Long idStock);

    Produit retrieveProduit(Long id);

    void assignFournisseurToProduit(Long fournisseurId, Long produitId);
    float getRevenuBrutProduit(Long idProduit, Date startDate, Date endDate);
}
