package dev.satyam.productservice.controllers;

import dev.satyam.productservice.dtos.CategoryDto;
import dev.satyam.productservice.dtos.ProductDto;
import dev.satyam.productservice.models.Category;
import dev.satyam.productservice.models.Product;
import dev.satyam.productservice.repositories.CategoryRepository;
import dev.satyam.productservice.services.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/{id}")
    public List<ProductDto> getCategory(@PathVariable("id") Long id){
        // using ProductDto bcs of infinite recursion issue
        // product contains category and category contains list of products , this will lead to issue
        Category category = categoryService.getCategory(id);
        List<Product> products = category.getProducts();
        // here the db query will be performed to fetch products of perticular category due to LAZY loading
        List<ProductDto> productDtos = new ArrayList<>();
        for(Product product : products){
            ProductDto productDto = new ProductDto();
            productDto.setImage(product.getImage());
            productDto.setDescription(product.getDescription());
            productDto.setPrice(product.getPrice());
            productDto.setTitle(product.getTitle());
            productDtos.add(productDto);
        }
        return productDtos;
    }

    @GetMapping
    public List<CategoryDto> getAllCategories(){
        List<Category> categories = categoryService.getAllCategories();
        List<CategoryDto> categoryDtos = new ArrayList<>();
        for(Category category: categories){
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setName(category.getName());
            categoryDtos.add(categoryDto);
        }
        return categoryDtos;
    }
}
