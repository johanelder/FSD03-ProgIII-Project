package com.example.SpringProject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "roomBookings")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "hotel", nullable = false, length = 20)
    @NotBlank(message = "Hotel is mandatory")
    private String hotel;

    @Column(nullable = true, length = 200)
    private String city;

    @Column(name = "type", nullable = false, length = 20)
    @NotBlank(message = "Type is mandatory")
    private String type;

    @Column(name = "room_id")
    private Long roomId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "end_date")
    private String endDate;

    @Column(name = "quantity")
    @Max(value = 4)
    private int quantity;

    @Column(name = "final_price")
    private Double finalPrice;

    @Column(name = "payment_status")
    private String paymentStatus;
}


