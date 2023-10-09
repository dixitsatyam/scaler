package dev.satyam.productservice.services;

import dev.satyam.productservice.models.Category;
import dev.satyam.productservice.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category getCategory(Long id){
        //Optional<Category> categoryOptional = categoryRepository.findById(UUID.fromString(uuid));
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if(categoryOptional.isEmpty())
            return null;
        Category category = categoryOptional.get();
        return category;
    }

    public List<Category> getAllCategories(){
        List<Category> categories= categoryRepository.findAll();
        return categories;
    }
}
