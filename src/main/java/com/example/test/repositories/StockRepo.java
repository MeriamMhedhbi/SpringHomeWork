package com.example.test.repositories;

import com.example.test.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepo extends JpaRepository<Stock,Long> {
}
