package com.example.test.services;

import com.example.test.entity.Client;
import com.example.test.entity.Facture;
import com.example.test.repositories.ClientRepo;
import com.example.test.repositories.FactureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FactureImp implements IFactureService{
    @Autowired
    FactureRepo factureRepo;

    @Autowired
    ClientRepo clientRepo;

    @Override
    public List<Facture> retrieveAllFactures() {
        return factureRepo.findAll();
    }

    @Override
    public void cancelFacture(Long id) {
        Facture facture = factureRepo.findById(id).orElse(null) ;
        facture.setActive(false);
        factureRepo.save(facture);
    }

    @Override
    public Facture retrieveFacture(Long id) {
        return factureRepo.findById(id).orElse(null);
    }

    @Override
    public List<Facture> getFacturesByClient(Long idClient) {
        Client c = clientRepo.findById(idClient).orElse(null);
        if (c!=null){
            return factureRepo.findFactureByClient(c);
        }
      return null;
    }
}
