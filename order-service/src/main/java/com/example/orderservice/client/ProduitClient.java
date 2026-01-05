package com.example.orderservice.client;

import com.example.productservice.dto.ProduitDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service")
public interface ProduitClient {
    @GetMapping("/produits/{id}")
    ProduitDto obtenirProduit(@PathVariable("id") Long id);
}