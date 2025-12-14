package com.example.kataapicervezasspringbootfalbmun0906.controller;

import com.example.kataapicervezasspringbootfalbmun0906.model.Brewery;
import com.example.kataapicervezasspringbootfalbmun0906.repository.BreweryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BreweryController {
    private final BreweryRepository breweryRepository;

    public BreweryController(BreweryRepository breweryRepository) {
        this.breweryRepository = breweryRepository;
    }

    @GetMapping("/breweries")
    public List<Brewery> getAll() {
        return breweryRepository.findAll();
    }

    @GetMapping("/brewerie/{id}")
    public ResponseEntity<Brewery> getById(@PathVariable Long id) {
        Optional<Brewery> brewery = breweryRepository.findById(id);
        return brewery.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}