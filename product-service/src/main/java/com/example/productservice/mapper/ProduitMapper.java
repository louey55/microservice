package com.example.productservice.mapper;

import com.example.productservice.dto.ProduitDto;
import com.example.productservice.entity.ProduitEntity;
import org.springframework.stereotype.Component;

@Component
public class ProduitMapper {

    public ProduitDto versDto(ProduitEntity entity) {
        ProduitDto dto = new ProduitDto();
        dto.setId(entity.getId());
        dto.setNom(entity.getNom());
        dto.setPrix(entity.getPrix());
        return dto;
    }

    public ProduitEntity versEntity(ProduitDto dto) {
        ProduitEntity entity = new ProduitEntity();
        entity.setId(dto.getId());
        entity.setNom(dto.getNom());
        entity.setPrix(dto.getPrix());
        return entity;
    }
}