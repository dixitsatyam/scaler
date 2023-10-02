package dev.satyam.productservice.models;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PriceRepository extends JpaRepository<Price, UUID> {
}