package dev.satyam.productservice.controllers;

import dev.satyam.productservice.dtos.GenericProductDto;
import dev.satyam.productservice.exceptions.NotFoundException;
import dev.satyam.productservice.services.FakeStoreProductService;
import dev.satyam.productservice.services.ProductService;
import dev.satyam.productservice.services.SelfProductServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductControllerTest {
    @MockBean
    private SelfProductServiceImpl productService;

    @Autowired
    private ProductController productController;

    @Test
    void returnNullWhenProductDoesntExist() throws NotFoundException {
        //GenericProductDto genericProductDto1 = new GenericProductDto();
        //genericProductDto1.setTitle("new phone dummy");
        when(
                productService.getProductById(any(Long.class))
        ).thenReturn(null);

        GenericProductDto genericProductDto = productController.getProductById(123L);
        assertNull(genericProductDto);
    }
    @Test
    void throwExceptionWhenProductDoesNotExist() throws NotFoundException{
        when(
                productService.getProductById(any(Long.class))
        ).thenThrow(new NotFoundException("Product not found"));

        assertThrows(NotFoundException.class, () -> productController.getProductById(123L));
    }
    @Test
    void returnSameProductWhenProductExists() throws NotFoundException{
        GenericProductDto genericProductDto = new GenericProductDto();
        when(
                productService.getProductById(any(Long.class))
        ).thenReturn(genericProductDto);
        assertEquals(genericProductDto, productController.getProductById(121L));
    }



}
