package com.example.test.repositories;

import com.example.test.entity.Produit;
import com.example.test.entity.Rayon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RayonRepo extends JpaRepository<Rayon,Long> {
}
