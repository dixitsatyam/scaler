package dev.satyam.productservice;

import dev.satyam.productservice.models.Category;
import dev.satyam.productservice.models.Price;
import dev.satyam.productservice.models.PriceRepository;
import dev.satyam.productservice.models.Product;
import dev.satyam.productservice.repositories.CategoryRepository;
import dev.satyam.productservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;
import java.util.UUID;

@SpringBootApplication
public class ProductserviceApplication implements CommandLineRunner {

	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;
	private final PriceRepository priceRepository;

	public ProductserviceApplication(ProductRepository productRepository,
									 CategoryRepository categoryRepository,
									 PriceRepository priceRepository) {
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
		this.priceRepository = priceRepository;
	}

	public static void main(String[] args) {

		SpringApplication.run(ProductserviceApplication.class, args);

	}
	@Override
	public void run(String... args) throws Exception{
		Category category = new Category();
		category.setName("samsung device");
		Category savedCategory = categoryRepository.save(category);

		Price price = new Price();
		price.setCurrency("rupee");
		price.setPrice(99000);
		Price savedPrice = priceRepository.save(price);

		Product product = new Product();
		product.setTitle("samsung z-flip");
		product.setDescription("samsung foldable");
		product.setPrice(savedPrice);
		product.setCategory(savedCategory);
		productRepository.save(product);
//		Optional<Category> category1 = categoryRepository.findById(UUID.fromString("11f8b66f-79e7-4f05-a9e0-665d5a8c9fd4"));
//		System.out.println("Category name is :"+ category1.get().getName());
//		System.out.println("Printing all products of this category");
//		Thread.sleep(1000);
//		for(Product product1:category1.get().getProducts()){
//			System.out.println("product :"+ product1.getTitle());
//		}
	}

}
