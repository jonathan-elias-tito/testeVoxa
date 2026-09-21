package com.TrabalhoCibele.Voxa.Entidades.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TrabalhoCibele.Voxa.Entities.Product;
import com.TrabalhoCibele.Voxa.Repository.ProductRepository;

@Service
public class ProductService {

    private  ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com o ID: " + id));
    }

    public Product insert(Product obj) {
        return productRepository.save(obj);
    }

    public void deleteById(Long id) {
        productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com o ID: " + id));
        productRepository.deleteById(id);
    }

    public Product update(Long id, Product obj) {
        Product entity = findById(id);
        entity.setName(obj.getName());
        entity.setDescription(obj.getDescription());
        entity.setPrice(obj.getPrice());
        entity.setImgUrl(obj.getImgUrl());
        return productRepository.save(entity);
    }
}