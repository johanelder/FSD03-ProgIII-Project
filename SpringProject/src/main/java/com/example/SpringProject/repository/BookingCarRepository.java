package com.example.SpringProject.repository;

import com.example.SpringProject.entity.BookingCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingCarRepository extends JpaRepository<BookingCar, Long>  {
}

