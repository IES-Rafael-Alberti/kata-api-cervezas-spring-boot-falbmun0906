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
                    // Actualización parcial: solo actualizar campos que no son null
                    if (beerDetails.getName() != null) {
                        beer.setName(beerDetails.getName());
                    }
                    if (beerDetails.getAbv() != null) {
                        beer.setAbv(beerDetails.getAbv());
                    }
                    if (beerDetails.getIbu() != null) {
                        beer.setIbu(beerDetails.getIbu());
                    }
                    if (beerDetails.getSrm() != null) {
                        beer.setSrm(beerDetails.getSrm());
                    }
                    if (beerDetails.getEbc() != null) {
                        beer.setEbc(beerDetails.getEbc());
                    }
                    if (beerDetails.getStyle_id() != null) {
                        beer.setStyle_id(beerDetails.getStyle_id());
                    }
                    if (beerDetails.getBrewery_id() != null) {
                        beer.setBrewery_id(beerDetails.getBrewery_id());
                    }
                    if (beerDetails.getCategory_id() != null) {
                        beer.setCategory_id(beerDetails.getCategory_id());
                    }
                    if (beerDetails.getDescription() != null) {
                        beer.setDescription(beerDetails.getDescription());
                    }
                    return ResponseEntity.ok(beerRepository.save(beer));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PatchMapping("/beer/{id}")
    public ResponseEntity<Beer> partialUpdateBeer(@PathVariable Long id, @RequestBody Beer beerDetails) {
        return updateBeer(id, beerDetails);
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


