package dev.satyam.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Category extends BaseModel{
    private String name;
    //if Fetch type is EAGER then list will be fetched at time of initialization
    // in case of LAZY only name will be fetched
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    private List<Product> products;
    //this is the same relation being mapped by category attribute in other(product) class
    // put mappedBy in only 1:m or 1:1 side
}
