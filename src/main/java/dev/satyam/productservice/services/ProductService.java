package dev.satyam.productservice.services;

import dev.satyam.productservice.dtos.GenericProductDto;
import dev.satyam.productservice.models.Product;

public interface ProductService {
    public GenericProductDto getProductById(Long id);
}
