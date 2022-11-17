package com.example.test.services;

import com.example.test.entity.Facture;

import java.util.List;

public interface IFactureService {

    List<Facture> retrieveAllFactures();
    void cancelFacture(Long id);
    Facture retrieveFacture(Long id);
    List<Facture> getFacturesByClient(Long idClient);
}
