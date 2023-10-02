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

import java.util.List;
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
		category.setName("oppo device");
//		Category savedCategory = categoryRepository.save(category);

		Price price = new Price();
		price.setCurrency("rupee");
		price.setPrice(20000);
//		Price savedPrice = priceRepository.save(price);

		Product product = new Product();
		product.setTitle("oppo v20");
		product.setDescription("china mobile");
		product.setPrice(price);
		product.setCategory(category);
		productRepository.save(product);
//		Optional<Category> category1 = categoryRepository.findById(UUID.fromString("11f8b66f-79e7-4f05-a9e0-665d5a8c9fd4"));
//		System.out.println("Category name is :"+ category1.get().getName());
//		System.out.println("Printing all products of this category");
//		Thread.sleep(1000);
//		for(Product product1:category1.get().getProducts()){
//			System.out.println("product :"+ product1.getTitle());
//		}
		//productRepository.deleteById(UUID.fromString("275440af-0e8d-43fe-a79e-acfa45030391"));
		Product p = productRepository.findByTitle("samsung s23 ultra");
		System.out.println("prod desc is :"+ p.getDescription());
//		List<Product> products = productRepository.findAllByPrice_Price(99000);
//		System.out.println("all product of price 99000 are");
//		for(Product product1: products){
//			System.out.println("product title:"+ product1.getTitle());
//		}

		List<Product> products = productRepository.findAllByTitle("samsung z-flip");
		System.out.println("all product of title samsung z-flip are");
		for(Product product1: products){
			System.out.println("product description:"+ product1.getDescription());
		}
		//productRepository.deleteAllByTitle("samsung z-flip");
		// not able to impliment this , try again later

	}

}
