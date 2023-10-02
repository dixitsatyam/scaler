package dev.satyam.productservice.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Order extends BaseModel{
    // in manytomany case join table will be created will have 2 id columns
    @JoinTable(name = "product_orders",          // join table name
    joinColumns = @JoinColumn(name = "order_id"),   // left table id
    inverseJoinColumns = @JoinColumn(name = "product_id")  // right table id
    )
    @ManyToMany
    private List<Product> products;
}
