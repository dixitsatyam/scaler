package dev.satyam.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
@Entity
@Setter
@Getter
public class Product extends BaseModel{
    private String title;
    private String description;
    private String image;
    @ManyToOne
    private Category category;
    private double price;
}
