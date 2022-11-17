package com.example.test.services;

import com.example.test.entity.*;
import com.example.test.repositories.FournisseurRepo;
import com.example.test.repositories.ProduitRepo;
import com.example.test.repositories.RayonRepo;
import com.example.test.repositories.StockRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProduitImp implements IProduitService{
    @Autowired
    ProduitRepo produitRepo;
    @Autowired
    RayonRepo rayonRepo;

    @Autowired
    StockRepo stockRepo;

    @Autowired
    FournisseurRepo fournisseurRepo;

    @Override
    public List<Produit> retrieveAllProduits() {
        return produitRepo.findAll();
    }

    @Override
    public Produit addProduit(Produit p, Long idRayon, Long idStock) {
        Rayon r=rayonRepo.findById(idRayon).orElse(null);
        Stock s =stockRepo.findById(idStock).orElse(null);
        if(r != null && s!=null){
            p.setRayon(r);
            p.setStock(s);
        }
        return  produitRepo.save(p);
    }

    @Override
    public Produit retrieveProduit(Long id) {
        return produitRepo.findById(id).orElse(null);
    }

    @Override
    public void assignFournisseurToProduit(Long fournisseurId, Long produitId) {
        Produit p = produitRepo.findById(produitId).orElse(null);
        Fournisseur f = fournisseurRepo.findById(fournisseurId).orElse(null);

        if(p!=null && f!= null){
            List<Fournisseur> fournisseurs = p.getFournisseurs();
            fournisseurs.add(f);
            produitRepo.save(p);
        }
    }

    @Override
    public float getRevenuBrutProduit(Long idProduit, Date startDate, Date endDate) {
        Produit p = produitRepo.findById(idProduit).orElse(null);
        float revenue =0 ;
        if(p!=null){
            List<DetailFacture> factures = p.getDetailFactureList();
            for (DetailFacture df:factures) {
                if(df.getFacture().getDateFacture().before(endDate) && df.getFacture().getDateFacture().after(startDate) && df.getFacture().getActive()==false){
                   revenue+= df.getPrixTotal()*df.getQte();
                }
            }
        }
       return  revenue;
    }
}
