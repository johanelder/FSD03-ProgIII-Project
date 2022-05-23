package com.example.SpringProject.repository;

import com.example.SpringProject.entity.Room;
import com.example.SpringProject.entity.RoomBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomBookingRepository extends JpaRepository<RoomBooking, Long> {

  @Query("SELECT rb FROM RoomBooking rb WHERE rb.userId = ?1")
    List<RoomBooking> findByUserId(Long userId);



}
