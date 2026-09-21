package com.TrabalhoCibele.Voxa.Entidades.Resources;

import java.util.List;
import com.TrabalhoCibele.Voxa.Repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TrabalhoCibele.Voxa.Entidades.Services.CategoryService;
import com.TrabalhoCibele.Voxa.Entities.Category;

@RestController
@RequestMapping(value = "/Categories")
public class CategoryResources {

	private final UserRepository userRepository;
	private CategoryService categoryService;

	public CategoryResources(CategoryService categoryService, UserRepository userRepository) {
		this.categoryService = categoryService;
		this.userRepository = userRepository;
	}

	@GetMapping
	public ResponseEntity<List<Category>> findAllCategories() {
		List<Category> list = categoryService.findAllCategories();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Long> findById(Long id) {
		categoryService.findById(id);
		return ResponseEntity.ok().body(id);

	}

	@PostMapping
	public ResponseEntity<Category> InsertCategory(Category category) {
		categoryService.InsertCategory(category);
		return ResponseEntity.ok().body(category);
	}
	@DeleteMapping
	public void DeleteById(Long id){
		categoryService.DeleteById(id);
	}
}
