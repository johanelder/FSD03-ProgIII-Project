package com.example.SpringProject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "rooms")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "hotel", nullable = false, length = 20)
    @NotBlank(message = "Hotel is mandatory")
    private String hotel;

    @Column(name = "type", nullable = false, length = 20)
    @NotBlank(message = "Type is mandatory")
    private String type;

    @Column(name = "beds", nullable = false, length = 20)
    @NotBlank(message = "Beds is mandatory")
    private String beds;

    @Column(name = "price", nullable = false, length = 5)
    @NotNull(message = "Price is necessary")
    private double price;

    @Column(nullable = true, length = 200)
    private String image;

    @Column(nullable = true, length = 200)
    private String description;

    @Column(nullable = true, length = 200)
    private String city;

    @Column(nullable = false)
    private boolean isBooked;

}