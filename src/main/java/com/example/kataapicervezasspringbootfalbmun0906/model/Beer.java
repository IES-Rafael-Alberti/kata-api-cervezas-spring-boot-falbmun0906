package com.example.kataapicervezasspringbootfalbmun0906.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "beers")
public class Beer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double abv;
    private Integer ibu;
    private Integer srm;
    private Integer ebc;
    private Integer style_id;
    private Integer brewery_id;
    private Integer category_id;
    private String description;
}