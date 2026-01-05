package com.example.orderservice.client;

import com.example.userservice.dto.UtilisateurDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service")
public interface UtilisateurClient {
    @GetMapping("/utilisateurs/{id}")
    UtilisateurDto obtenirUtilisateur(@PathVariable("id") Long id);
}