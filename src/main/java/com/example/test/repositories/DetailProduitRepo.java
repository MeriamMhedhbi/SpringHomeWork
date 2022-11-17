package com.example.test.repositories;

import com.example.test.entity.DetailProduit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailProduitRepo extends JpaRepository<DetailProduit,Long> {
}
