package com.example.orderservice.service;

import com.example.orderservice.client.ProduitClient;
import com.example.orderservice.client.UtilisateurClient;
import com.example.orderservice.dto.CommandeDto;
import com.example.orderservice.entity.CommandeEntity;
import com.example.orderservice.mapper.CommandeMapper;
import com.example.orderservice.repository.CommandeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommandeService {

    private final CommandeRepository repository;
    private final CommandeMapper mapper;
    private final UtilisateurClient utilisateurClient;
    private final ProduitClient produitClient;

    public CommandeDto creer(CommandeDto dto) {
        // Validation
        utilisateurClient.obtenirUtilisateur(dto.getUtilisateurId());
        produitClient.obtenirProduit(dto.getProduitId());

        CommandeEntity entity = mapper.versEntity(dto);
        return mapper.versDto(repository.save(entity));
    }

    public java.util.List<CommandeDto> listerTous() {
        return repository.findAll().stream()
                .map(mapper::versDto)
                .toList();
    }
}