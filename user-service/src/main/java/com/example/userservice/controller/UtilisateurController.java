package com.example.userservice.controller;

import com.example.userservice.dto.UtilisateurDto;
import com.example.userservice.service.UtilisateurService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utilisateurs")
@RequiredArgsConstructor
public class UtilisateurController {

    private final UtilisateurService service;

    @GetMapping
    public List<UtilisateurDto> lister() {
        return service.listerTous();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UtilisateurDto> obtenir(@PathVariable Long id) {
        return service.trouverParId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public UtilisateurDto creer(@RequestBody UtilisateurDto dto) {
        return service.creer(dto);
    }
}