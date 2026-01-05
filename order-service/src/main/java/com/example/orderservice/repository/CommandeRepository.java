package com.example.orderservice.repository;

import com.example.orderservice.entity.CommandeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<CommandeEntity, Long> {
}