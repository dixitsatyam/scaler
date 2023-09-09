package dev.satyam.productservice.services;

import dev.satyam.productservice.dtos.GenericProductDto;
import dev.satyam.productservice.models.Product;

import java.util.List;

public interface ProductService {
     GenericProductDto getProductById(Long id);
     GenericProductDto createProduct(GenericProductDto product);
     List<GenericProductDto> getAllProducts();
}
