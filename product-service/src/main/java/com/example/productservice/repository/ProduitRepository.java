package com.example.productservice.repository;

import com.example.productservice.entity.ProduitEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<ProduitEntity, Long> {
}