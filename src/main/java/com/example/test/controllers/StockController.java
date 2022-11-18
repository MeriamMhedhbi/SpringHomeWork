package com.example.test.controllers;

import com.example.test.entity.Stock;
import com.example.test.services.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    IStockService iStockService;


    @GetMapping("retrieveAllStocks")
    public List<Stock> retrieveAllStocks(){
       return iStockService.retrieveAllStocks();
    }

    @PostMapping("addStock")
    public Stock addStock(@RequestBody Stock s){
        return  iStockService.addStock(s);
    }

    @PutMapping("updateStock")
    public Stock updateStock(@RequestBody Stock s){
        return  iStockService.updateStock(s);
    }

    @GetMapping("retrieveStock/{id}")
    public Stock retrieveStock(@PathVariable("id") Long id){
        return iStockService.retrieveStock(id);
    }

    @PostMapping("assignProduitToStock/{idProduit}/{idStock}")
    public void assignProduitToStock(@PathVariable("idProduit") Long idProduit,@PathVariable("idStock") Long idStock){
        iStockService.assignProduitToStock(idProduit,idStock);
    }

}
