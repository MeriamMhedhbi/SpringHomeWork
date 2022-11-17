package com.example.test.services;

import com.example.test.entity.CategorieClient;
import com.example.test.entity.Client;
import com.example.test.entity.Facture;
import com.example.test.repositories.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ClientServiceImp implements IClientService {

    @Autowired
    ClientRepo clientRepo;

    @Override
    public List<Client> retrieveAllClients() {

        return clientRepo.findAll();
    }

    @Override
    public Client addClient(Client c) {

        return clientRepo.save(c);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepo.deleteById(id);
    }

    @Override
    public Client updateClient(Client c) {
        return clientRepo.save(c);
    }

    @Override
    public Client retrieveClient(Long id) {
        return clientRepo.findById(id).orElse(null);
    }

    @Override
    public float getChiffreAffaireParCategorieClient(CategorieClient categorieClient, Date startDate, Date endDate) {
      List<Client> clients =  clientRepo.findClientByCategorieClient(categorieClient);
      float chiffreAffaire=0;
        for (Client c:clients) {
            for (Facture f : c.getFactures()) {
                if (f.getDateFacture().before(endDate) && f.getDateFacture().after(startDate) && f.getActive() == false ){
                   chiffreAffaire+= f.getMontantFacture();
                }
            }
        }
        return chiffreAffaire ;
    }


}
