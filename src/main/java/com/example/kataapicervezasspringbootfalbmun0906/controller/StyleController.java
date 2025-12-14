package com.example.kataapicervezasspringbootfalbmun0906.controller;

import com.example.kataapicervezasspringbootfalbmun0906.model.Style;
import com.example.kataapicervezasspringbootfalbmun0906.repository.StyleRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StyleController {
    private final StyleRepository styleRepository;

    public StyleController(StyleRepository styleRepository) {
        this.styleRepository = styleRepository;
    }

    @GetMapping("/styles")
    public List<Style> getAll() {
        return styleRepository.findAll();
    }

    @GetMapping("/style/{id}")
    public ResponseEntity<Style> getById(@PathVariable Long id) {
        Optional<Style> style = styleRepository.findById(id);
        return style.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}


