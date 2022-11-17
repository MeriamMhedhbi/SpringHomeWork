package com.example.test.repositories;

import com.example.test.entity.Facture;
import com.example.test.entity.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FournisseurRepo  extends JpaRepository<Fournisseur,Long> {
}
