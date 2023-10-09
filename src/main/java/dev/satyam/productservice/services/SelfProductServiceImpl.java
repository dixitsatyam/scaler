package dev.satyam.productservice.services;

import dev.satyam.productservice.dtos.GenericProductDto;
import dev.satyam.productservice.exceptions.NotFoundException;
import dev.satyam.productservice.models.Category;
import dev.satyam.productservice.models.Price;
import dev.satyam.productservice.models.Product;
import dev.satyam.productservice.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("SelfProductServiceImpl")
public class SelfProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    public SelfProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public GenericProductDto getProductById(Long id) throws NotFoundException {
        Product product = productRepository.getProductById(id);
        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setDescription(product.getDescription());
        genericProductDto.setId(product.getId());
        genericProductDto.setPrice(product.getPrice().getPrice());
        genericProductDto.setCategory(product.getCategory().getName());
        genericProductDto.setImage(product.getImage());
        genericProductDto.setTitle(product.getTitle());

        return genericProductDto;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        Category category = new Category();
        Price price = new Price();
        Product product = new Product();
        category.setName(genericProductDto.getCategory());
        price.setPrice(genericProductDto.getPrice());
        product.setCategory(category);
        product.setPrice(price);
        product.setTitle(genericProductDto.getTitle());
        product.setDescription(genericProductDto.getDescription());
        product.setImage(genericProductDto.getImage());

        productRepository.save(product);
        return null;
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<GenericProductDto> genericProductDtos = new ArrayList<>();
        for(Product product: products){
            GenericProductDto genericProductDto = new GenericProductDto();
            genericProductDto.setDescription(product.getDescription());
            genericProductDto.setId(product.getId());
            genericProductDto.setPrice(product.getPrice().getPrice());
            genericProductDto.setCategory(product.getCategory().getName());
            genericProductDto.setImage(product.getImage());
            genericProductDto.setTitle(product.getTitle());
            genericProductDtos.add(genericProductDto);
        }
        return genericProductDtos;
    }
    @Transactional
    public GenericProductDto deleteProductById(Long id){
        productRepository.deleteProductById(id);
        return null;
    }
    //@Transactional is imp here , without this api is not working
    @Transactional
    public void updateProductById(Long id, GenericProductDto genericProductDto){
        productRepository.setProductById(id, genericProductDto.getTitle(), genericProductDto.getDescription());
    }
}
