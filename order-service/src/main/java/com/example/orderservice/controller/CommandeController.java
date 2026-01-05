package com.example.orderservice.controller;

import com.example.orderservice.dto.CommandeDto;
import com.example.orderservice.service.CommandeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commandes")
@RequiredArgsConstructor
public class CommandeController {

    private final CommandeService service;

    @PostMapping
    public CommandeDto creer(@RequestBody CommandeDto dto) {
        return service.creer(dto);
    }

    @GetMapping
    public List<CommandeDto> lister() {
        return service.listerTous();
    }
}