package com.example.kataapicervezasspringbootfalbmun0906.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "styles")
public class Style {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
