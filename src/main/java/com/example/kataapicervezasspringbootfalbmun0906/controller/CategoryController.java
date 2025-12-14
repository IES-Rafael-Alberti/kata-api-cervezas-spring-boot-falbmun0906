package com.example.kataapicervezasspringbootfalbmun0906.controller;

import com.example.kataapicervezasspringbootfalbmun0906.model.Category;
import com.example.kataapicervezasspringbootfalbmun0906.repository.CategoryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CategoryController {
    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/categories")
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @GetMapping("/categorie/{id}")
    public ResponseEntity<Category> getById(@PathVariable Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}

