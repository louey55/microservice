package com.example.orderservice.mapper;

import com.example.orderservice.dto.CommandeDto;
import com.example.orderservice.entity.CommandeEntity;
import org.springframework.stereotype.Component;

@Component
public class CommandeMapper {

    public CommandeDto versDto(CommandeEntity entity) {
        CommandeDto dto = new CommandeDto();
        dto.setId(entity.getId());
        dto.setUtilisateurId(entity.getUtilisateurId());
        dto.setProduitId(entity.getProduitId());
        dto.setQuantite(entity.getQuantite());
        return dto;
    }

    public CommandeEntity versEntity(CommandeDto dto) {
        CommandeEntity entity = new CommandeEntity();
        entity.setId(dto.getId());
        entity.setUtilisateurId(dto.getUtilisateurId());
        entity.setProduitId(dto.getProduitId());
        entity.setQuantite(dto.getQuantite());
        return entity;
    }
}