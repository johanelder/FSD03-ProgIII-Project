package com.example.SpringProject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cars")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cars {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category", nullable = false, length = 20)
    @NotBlank(message = "Category is mandatory")
    private String category;

    @Column(name = "make", nullable = false, length = 20)
    @NotBlank(message = "Make is mandatory")
    private String make;

    @Column(name = "model", nullable = false, length = 20)
    @NotBlank(message = "Model is mandatory")
    private String model;

    @Column(name = "price", nullable = false, length = 5)
    @NotNull(message = "Price is necessary")
    private double price;

    @Column(nullable = true, length = 200)
    private String image;

}
