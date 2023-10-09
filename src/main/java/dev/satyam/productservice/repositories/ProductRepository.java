package dev.satyam.productservice.repositories;

import dev.satyam.productservice.models.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
//<Product, UUID> >> Product is entity for which table is going to be created,
// and UUID is primary key of that entity
@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    //find product by title
    public Product findByTitle(String title);
    //find all product of a price
    public List<Product> findAllByPrice_Price(double price);
    // this is how we can use our custom query functions in english kind of laguage,
    // query is implemented by jpa only
    @Query(value = "select * from product where title = :title",nativeQuery = true)
    public List<Product> findAllByTitle(String title);
    // custom query if we want to use our own query and not jpa's
    // nativeQuery will be false if we use hybernet query language (hql)
    @Query(value = "delete from product where title = :title", nativeQuery = true)
    public List<Product> deleteAllByTitle(String title);

    List<Product> findAll();

    Product getProductById(Long id);

    void deleteProductById(Long id);
    @Modifying
    @Query(value = "update product p set p.title = :title, p.description = :description where p.id = :id",nativeQuery = true)
    void setProductById(Long id, String title, String description);
}
