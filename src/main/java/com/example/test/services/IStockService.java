package com.example.test.services;

import com.example.test.entity.Stock;

import java.util.List;

public interface IStockService {
    List<Stock> retrieveAllStocks();

    Stock addStock(Stock s);

    Stock updateStock(Stock u);

    Stock retrieveStock(Long id);

    void assignProduitToStock(Long idProduit, Long idStock);
}
