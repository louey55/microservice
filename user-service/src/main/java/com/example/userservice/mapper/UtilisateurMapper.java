package com.example.userservice.mapper;

import com.example.userservice.dto.UtilisateurDto;
import com.example.userservice.entity.UtilisateurEntity;
import org.springframework.stereotype.Component;

@Component
public class UtilisateurMapper {

    public UtilisateurDto versDto(UtilisateurEntity entity) {
        UtilisateurDto dto = new UtilisateurDto();
        dto.setId(entity.getId());
        dto.setNom(entity.getNom());
        dto.setEmail(entity.getEmail());
        return dto;
    }

    public UtilisateurEntity versEntity(UtilisateurDto dto) {
        UtilisateurEntity entity = new UtilisateurEntity();
        entity.setId(dto.getId());
        entity.setNom(dto.getNom());
        entity.setEmail(dto.getEmail());
        return entity;
    }
}