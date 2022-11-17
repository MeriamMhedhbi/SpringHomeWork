package com.example.test.services;

import com.example.test.entity.CategorieClient;
import com.example.test.entity.Client;

import java.util.Date;
import java.util.List;

public interface IClientService {
    List<Client> retrieveAllClients();
    Client addClient(Client c);
    void deleteClient(Long id);
    Client updateClient(Client c);
    Client retrieveClient(Long id);
    float getChiffreAffaireParCategorieClient(CategorieClient categorieClient, Date startDate, Date endDate);
}
