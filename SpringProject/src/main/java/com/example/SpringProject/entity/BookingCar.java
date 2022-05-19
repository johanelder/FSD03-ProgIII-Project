package com.example.SpringProject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;


@Entity
@Table(name = "bookingcars")
@Data
@AllArgsConstructor
@NoArgsConstructor


public class BookingCar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstName", nullable = false, length = 20)
    @NotBlank(message = "First name is mandatory")
    private String firstName;

    @Column(name = "lastName", nullable = false, length = 20)
    @NotBlank(message = "Last name is mandatory")
    private String lastName;

    @Column(name = "email", nullable = false, length = 20)
    @NotBlank(message = "Email is mandatory")
    private String email;

    @Column(name = "departure", nullable = false)
    @NotNull(message = "Departure date is mandatory")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date departure;

    @Column(name = "arrival", nullable = false)
    @NotNull(message = "Return date is mandatory")
    @DateTimeFormat (pattern="yyyy-MM-dd")
    private Date arrival;

    @Column(name = "car", nullable = true)
    private String car;

    @Column(name = "hotel", nullable = true)
    private String hotel;


}
