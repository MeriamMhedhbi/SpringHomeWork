package com.example.test.repositories;

import com.example.test.entity.DetailFacture;
import org.springframework.data.jpa.repository.JpaRepository;
public interface DetailFactureRepo extends JpaRepository<DetailFacture,Long> {
}
