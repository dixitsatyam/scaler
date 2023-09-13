package dev.satyam.productservice.controllers;

import dev.satyam.productservice.dtos.GenericProductDto;
import dev.satyam.productservice.dtos.NotFoundExceptionDto;
import dev.satyam.productservice.exceptions.NotFoundException;
import dev.satyam.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

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
    public List<GenericProductDto> getAllproducts(){
       return productService.getAllProducts();
    }
    // localhost:8080/products/123

    @GetMapping("{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id) throws NotFoundException {
       return productService.getProductById(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<GenericProductDto> deleteProductById(@PathVariable("id") Long id){
       GenericProductDto product = productService.deleteProductById(id);
       return new ResponseEntity<>(product, HttpStatus.OK);
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
