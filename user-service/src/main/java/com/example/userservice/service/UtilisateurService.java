package com.example.userservice.service;

import com.example.userservice.dto.UtilisateurDto;
import com.example.userservice.entity.UtilisateurEntity;
import com.example.userservice.mapper.UtilisateurMapper;
import com.example.userservice.repository.UtilisateurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UtilisateurService {

    private final UtilisateurRepository repository;
    private final UtilisateurMapper mapper;

    public List<UtilisateurDto> listerTous() {
        return repository.findAll()
                .stream()
                .map(mapper::versDto)
                .collect(Collectors.toList());
    }

    public Optional<UtilisateurDto> trouverParId(Long id) {
        return repository.findById(id).map(mapper::versDto);
    }

    public UtilisateurDto creer(UtilisateurDto dto) {
        UtilisateurEntity entity = mapper.versEntity(dto);
        return mapper.versDto(repository.save(entity));
    }
}