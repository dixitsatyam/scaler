package dev.satyam.productservice.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
//@Table(name = "custom_table_name") // this is how we can give our custom name to entity table
public class Product extends BaseModel{
    private String title;
    private String description;
    private String image;
    //@JoinColumn(name = "Category")    this is how we can give our custom name to foreign key
    @ManyToOne
    private Category category;
    @OneToOne
    private Price price;
}
