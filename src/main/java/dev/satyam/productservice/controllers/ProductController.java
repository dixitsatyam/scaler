package dev.satyam.productservice.controllers;

import dev.satyam.productservice.dtos.GenericProductDto;
import dev.satyam.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
 //   @Autowired
 // field injection - Not recommended
    private ProductService productService;
    //constructor injection
    public ProductController(@Qualifier("FakeStoreProductService") ProductService productService){
        this.productService = productService;
    }
    // setter injection - Not recommended
    /*@Autowired
    public void setProductService(ProductService productService){
     this.productService = productService;
    }*/
    @GetMapping
    public void getAllproducts(){

    }
    // localhost:8080/products/123

    @GetMapping("{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id){
           return productService.getProductById(id);
    }
    @DeleteMapping("{id}")
    public void deleteProductById(){

    }
    @PostMapping
    public GenericProductDto createProduct(@RequestBody GenericProductDto product){
            //System.out.println(product.getTitle());
            return productService.createProduct(product);
    }
    @PutMapping("{id}")
    public void updateProductById(){

    }
}
