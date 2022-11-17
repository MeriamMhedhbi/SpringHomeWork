package com.example.test.repositories;

import com.example.test.entity.Client;
import com.example.test.entity.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FactureRepo extends JpaRepository<Facture,Long> {
    List<Facture> findFactureByClient(Client client);
}
