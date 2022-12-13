package com.example.test.services;

import com.example.test.entity.Produit;
import com.example.test.entity.Stock;
import com.example.test.repositories.ProduitRepo;
import com.example.test.repositories.StockRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class StockImp implements IStockService{
    @Autowired
    StockRepo stockRepo;

    @Autowired
    ProduitRepo produitRepo;

    @Override
    public List<Stock> retrieveAllStocks() {
        return stockRepo.findAll() ;
    }

    @Override
    public Stock addStock(Stock s) {
        return stockRepo.save(s);
    }

    @Override
    public Stock updateStock(Stock u) {
        return stockRepo.save(u);
    }

    @Override
    public Stock retrieveStock(Long id) {
        return stockRepo.findById(id).orElse(null);
    }

    @Override
    public void assignProduitToStock(Long idProduit, Long idStock) {
        Produit p = produitRepo.findById(idProduit).orElse(null);
        Stock s = stockRepo.findById(idStock).orElse(null);

        if(p!=null && s!= null){
            List<Produit> produits = s.getProduits();
            produits.add(p);
            stockRepo.save(s);
        }

    }

    @Scheduled(cron = "0 0 22 ? * * *")
    @Override
    public String retrieveStatusStock() {
        stockRepo.findAll().stream().filter( stock -> stock.getQteMin()>stock.getQteStock())
                        .forEach(stock ->
                                log.info(
                                        stock.getProduits().toString())
                                );


        return null ;
    }


}
