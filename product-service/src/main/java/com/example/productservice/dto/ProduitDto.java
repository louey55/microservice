package com.example.productservice.dto;

import lombok.Data;

@Data
public class ProduitDto {
    private Long id;
    private String nom;
    private double prix;
}