package com.example.orderservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "commandes")
@Data
public class CommandeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long utilisateurId;
    private Long produitId;
    private Integer quantite;
}