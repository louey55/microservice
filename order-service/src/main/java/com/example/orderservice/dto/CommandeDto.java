package com.example.orderservice.dto;

import lombok.Data;

@Data
public class CommandeDto {
    private Long id;
    private Long utilisateurId;
    private Long produitId;
    private Integer quantite;
}