package com.example.kataapicervezasspringbootfalbmun0906.repository;

import com.example.kataapicervezasspringbootfalbmun0906.model.Beer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeerRepository extends JpaRepository<Beer, Long> {
}