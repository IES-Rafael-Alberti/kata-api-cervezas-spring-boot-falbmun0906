package com.example.kataapicervezasspringbootfalbmun0906.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "breweries")
public class Brewery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String city;
    private String country;
}
