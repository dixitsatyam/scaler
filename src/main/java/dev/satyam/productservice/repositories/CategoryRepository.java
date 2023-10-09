package dev.satyam.productservice.repositories;

import dev.satyam.productservice.models.Category;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {

    //Optional<Category> findById(UUID uuid);
    Optional<Category> findById(Long id);
    List<Category> findAll();
}
