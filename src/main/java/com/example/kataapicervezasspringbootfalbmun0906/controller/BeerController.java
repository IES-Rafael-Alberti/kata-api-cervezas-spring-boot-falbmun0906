package com.example.kataapicervezasspringbootfalbmun0906.controller;

import com.example.kataapicervezasspringbootfalbmun0906.model.Beer;
import com.example.kataapicervezasspringbootfalbmun0906.repository.BeerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BeerController {
    private final BeerRepository beerRepository;

    public BeerController(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @GetMapping("/beers")
    public List<Beer> getAllBeers() {
        return beerRepository.findAll();
    }

    @GetMapping("/beer/{id}")
    public ResponseEntity<Beer> getBeerById(@PathVariable Long id) {
        Optional<Beer> beer = beerRepository.findById(id);
        return beer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/beer")
    public Beer createBeer(@RequestBody Beer beer) {
        return beerRepository.save(beer);
    }

    @PutMapping("/beer/{id}")
    public ResponseEntity<Beer> updateBeer(@PathVariable Long id, @RequestBody Beer beerDetails) {
        return beerRepository.findById(id)
                .map(beer -> {
                    beer.setName(beerDetails.getName());
                    beer.setAbv(beerDetails.getAbv());
                    beer.setIbu(beerDetails.getIbu());
                    beer.setSrm(beerDetails.getSrm());
                    beer.setEbc(beerDetails.getEbc());
                    beer.setStyle_id(beerDetails.getStyle_id());
                    beer.setBrewery_id(beerDetails.getBrewery_id());
                    beer.setCategory_id(beerDetails.getCategory_id());
                    beer.setDescription(beerDetails.getDescription());
                    return ResponseEntity.ok(beerRepository.save(beer));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/beer/{id}")
    public ResponseEntity<Void> deleteBeer(@PathVariable Long id) {
        if (beerRepository.existsById(id)) {
            beerRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}


