package dev.satyam.productservice.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

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
    //CascadeType.PERSIST, it means that when you save an entity,
    // the associated entities should also be saved automatically
    @ManyToOne(cascade =  {CascadeType.PERSIST, CascadeType.REMOVE})
    private Category category;
    // CascadeType.REMOVE, it means that when you delete an entity,
    // the associated entities should also be deleted automatically
    // if a prod is deleted then corresponding price and category
    // will also be deleted
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Price price;
}
