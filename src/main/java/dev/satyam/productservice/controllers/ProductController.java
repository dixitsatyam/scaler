package dev.satyam.productservice.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products/")
public class ProductController {
    @GetMapping
    public void getAllproducts(){

    }
    // localhost:8080/products/123

    @GetMapping("{id}")
    public String getProductById(@PathVariable("id") Long id){
           return "Here is product id "+ id;
    }
    @DeleteMapping("{id}")
    public void deleteProductById(){

    }
    @PostMapping("{id}")
    public void createProduct(){

    }
    @PutMapping("{id}")
    public void updateProductById(){

    }
}
