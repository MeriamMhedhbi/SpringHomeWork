package com.example.test.controllers;

import com.example.test.entity.CategorieClient;
import com.example.test.entity.Client;
import com.example.test.entity.Stock;
import com.example.test.services.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    IClientService iClientService;

    @GetMapping("retrieveAllClients")
    public List<Client> retrieveAllClients(){
        return iClientService.retrieveAllClients();
    }

    @PostMapping("addClient")
    public Client addClient(@RequestBody Client c){
        return  iClientService.addClient(c);
    }

    @PutMapping("updateClient")
    public Client updateClient(@RequestBody Client c){
        return  iClientService.updateClient(c);
    }

    @GetMapping("retrieveClient/{id}")
    public Client retrieveClient(@PathVariable("id") Long id){
        return iClientService.retrieveClient(id);
    }
    @DeleteMapping ("deleteClient/{id}")
    public void deleteClient(@PathVariable("id") Long id){
         iClientService.deleteClient(id);
    }

    @PostMapping("getChiffreAffaireParCategorieClient/{categorieClient}/{startDate}/{endDate}")
    float getChiffreAffaireParCategorieClient(@PathVariable ("categorieClient") CategorieClient categorieClient,@PathVariable ("startDate") Date startDate, @PathVariable("endDate") Date endDate){
        return iClientService.getChiffreAffaireParCategorieClient(categorieClient,startDate,endDate);
    }
}
