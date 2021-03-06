package com.example.SpringProject.repository;

import com.example.SpringProject.entity.Hotels;
import com.example.SpringProject.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotels, Long> {
}
