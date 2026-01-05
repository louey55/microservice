package com.example.productservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "produits")
@Data
public class ProduitEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private double prix;
}