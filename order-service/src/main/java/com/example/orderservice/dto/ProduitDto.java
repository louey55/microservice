package com.example.orderservice.dto;

import lombok.Data;

@Data
public class ProduitDto {
    private Long id;
    private String nom;
    private Double prix;
}
