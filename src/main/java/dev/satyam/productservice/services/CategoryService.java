package dev.satyam.productservice.services;

import dev.satyam.productservice.models.Category;
import dev.satyam.productservice.models.Product;

import java.util.List;

public interface CategoryService {
    Category getCategory(Long id);

    List<Category> getAllCategories();
}
