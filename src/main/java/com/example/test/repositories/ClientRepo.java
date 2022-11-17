package com.example.test.repositories;

import com.example.test.entity.CategorieClient;
import com.example.test.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepo extends JpaRepository<Client,Long> {
    List<Client> findClientByCategorieClient(CategorieClient categorieClient);
}
