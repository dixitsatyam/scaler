package dev.satyam.productservice.dtos;

import dev.satyam.productservice.models.Category;
import dev.satyam.productservice.models.Price;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private String title;
    private String description;
    private String image;
    private Price price;
}
