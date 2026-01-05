package com.example.productservice.controller;

import com.example.productservice.dto.ProduitDto;
import com.example.productservice.service.ProduitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produits")  // ← Changé ici
@RequiredArgsConstructor
public class ProduitController {

    private final ProduitService service;

    @GetMapping
    public List<ProduitDto> lister() {
        return service.listerTous();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProduitDto> obtenir(@PathVariable Long id) {
        return service.trouverParId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ProduitDto creer(@RequestBody ProduitDto dto) {
        return service.creer(dto);
    }
}