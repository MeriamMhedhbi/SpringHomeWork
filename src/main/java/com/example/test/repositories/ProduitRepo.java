package com.example.test.repositories;

import com.example.test.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepo extends JpaRepository<Produit,Long> {
}
