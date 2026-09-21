package com.TrabalhoCibele.Voxa.Entidades.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.TrabalhoCibele.Voxa.Entidades.Resources.CategoryResources;
import com.TrabalhoCibele.Voxa.Entities.Category;
import com.TrabalhoCibele.Voxa.Repository.CategoryRepository;

@Service
public class CategoryService {

	private CategoryRepository categoryRepository;

	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	public List<Category> findAllCategories() {
		return categoryRepository.findAll();
	}

	public Category InsertCategory(Category category) {
		return categoryRepository.save(category);
	}

	public Category findById(Long id) {
		Optional<Category> obj = categoryRepository.findById(id);
		return obj.orElseThrow(() -> new RuntimeException("Objeto não encontrado"));
	}

	public void DeleteById(Long id) {
		categoryRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Categoria não encontrada com o ID: " + id));
		categoryRepository.deleteById(id);
	}
}
