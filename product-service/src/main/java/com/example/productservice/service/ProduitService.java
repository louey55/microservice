package com.example.productservice.service;

import com.example.productservice.dto.ProduitDto;
import com.example.productservice.entity.ProduitEntity;
import com.example.productservice.mapper.ProduitMapper;
import com.example.productservice.repository.ProduitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProduitService {

    private final ProduitRepository repository;
    private final ProduitMapper mapper;

    public List<ProduitDto> listerTous() {
        return repository.findAll()
                .stream()
                .map(mapper::versDto)
                .collect(Collectors.toList());
    }

    public Optional<ProduitDto> trouverParId(Long id) {
        return repository.findById(id).map(mapper::versDto);
    }

    public ProduitDto creer(ProduitDto dto) {
        ProduitEntity entity = mapper.versEntity(dto);
        return mapper.versDto(repository.save(entity));
    }
}