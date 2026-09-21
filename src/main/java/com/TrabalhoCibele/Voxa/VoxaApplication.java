package com.TrabalhoCibele.Voxa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.TrabalhoCibele.Voxa.Entities.Category;
import com.TrabalhoCibele.Voxa.Entities.Product;
import com.TrabalhoCibele.Voxa.Entities.User;
import com.TrabalhoCibele.Voxa.Repository.CategoryRepository;
import com.TrabalhoCibele.Voxa.Repository.ProductRepository;
import com.TrabalhoCibele.Voxa.Repository.UserRepository;


@SpringBootApplication
public class VoxaApplication implements CommandLineRunner {

	private final CategoryRepository categoryRepository;
	private final UserRepository userRepository;
	private final ProductRepository productRepository;

	@Autowired
	public VoxaApplication(CategoryRepository categoryRepository, 
						   UserRepository userRepository, 
						   ProductRepository productRepository) {
		this.categoryRepository = categoryRepository;
		this.userRepository = userRepository;
		this.productRepository = productRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(VoxaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// --- TESTE DE USUÁRIOS ---
		User user1 = new User(null, "Vitor", "vitor@gmail.com", 123456);
		User user2 = new User(null, "Maria", "maria@gmail.com", 654321);
		userRepository.save(user1);
		userRepository.save(user2);
		System.out.println("Usuários salvos: " + userRepository.findAll());

		// --- TESTE DE CATEGORIAS ---
		Category cat1 = new Category(null, "Botas");
		Category cat2 = new Category(null, "Tênis");
		Category cat3 = new Category(null, "Grifes");
		categoryRepository.save(cat1);
		categoryRepository.save(cat2);
		categoryRepository.save(cat3);
		System.out.println("Categoria encontrada por ID: " + categoryRepository.findById(cat3.getId()));

		categoryRepository.deleteById(cat3.getId());
		System.out.println("Categoria " + cat3.getName() + " deletada com sucesso.");

		// --- TESTE DE PRODUTOS ---
		Product p1 = new Product(null, "Tênis Esportivo", "Ideal para corridas", 299.90, "http://img.com/p1.jpg");
		Product p2 = new Product(null, "Bota de Couro", "Bota resistente ao frio", 450.00, "http://img.com/p2.jpg");
		productRepository.save(p1);
		productRepository.save(p2);
		System.out.println("Produtos salvos: " + productRepository.findAll());

		productRepository.deleteById(p1.getId());
		System.out.println("Produto " + p1.getName() + " deletado com sucesso.");
	}
}