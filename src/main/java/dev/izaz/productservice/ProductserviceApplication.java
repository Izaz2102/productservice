package dev.izaz.productservice;

import dev.izaz.productservice.inheritancedemo.singletable.Mentor;
//import dev.izaz.productservice.inheritancedemo.singletable.MentorRepository;
import dev.izaz.productservice.inheritancedemo.joinedtable.MentorRepository;
import dev.izaz.productservice.inheritancedemo.joinedtable.User;
//import dev.izaz.productservice.inheritancedemo.singletable.UserRepository;
import dev.izaz.productservice.inheritancedemo.joinedtable.UserRepository;
import dev.izaz.productservice.models.Category;
import dev.izaz.productservice.models.Product;
import dev.izaz.productservice.repositories.CategoryRepository;
import dev.izaz.productservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ProductserviceApplication implements CommandLineRunner {
//public class ProductserviceApplication {

	private MentorRepository mentorRepository;
	private UserRepository userRepository;
	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;

	public ProductserviceApplication(@Qualifier("jt_mr") MentorRepository mentorRepository,
									 @Qualifier("jt_ur") UserRepository userRepository,
									 ProductRepository productRepository,
									 CategoryRepository categoryRepository) {
		this.mentorRepository = mentorRepository;
		this.userRepository = userRepository;
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(ProductserviceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*Mentor mentor = new Mentor();
		mentor.setName("Izaz");
		mentor.setEmail("izaz2102@scaler.com");
		mentor.setAverageRating(6.2);
		mentorRepository.save(mentor);

		User user = new User();
		user.setName("test");
		user.setEmail("test@scaler.com");
		userRepository.save(user);

		List<User> users = userRepository.findAll();
		for (User user1 : users){
			System.out.println(user1.getName());
		}*/
		Category category = new Category();
		category.setName("Apple devices");
		Category savedCategory = categoryRepository.save(category);

		Product product = new Product();
		product.setTitle("i phone");
		product.setDescription("TEST");
		product.setCategory(savedCategory);

		productRepository.save(product);
	}
}
