package dev.satyam.productservice.services;

import dev.satyam.productservice.dtos.GenericProductDto;
import dev.satyam.productservice.exceptions.NotFoundException;
import dev.satyam.productservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("SelfProductServiceImpl")
public class SelfProductServiceImpl implements ProductService{
    @Override
    public GenericProductDto getProductById(Long id) throws NotFoundException {
        return null;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto product) {
            return null;
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        return null;
    }
    public GenericProductDto deleteProductById(Long id){
        return null;
    }
}
