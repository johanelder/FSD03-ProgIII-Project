package com.example.SpringProject.repository;

import com.example.SpringProject.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface RoomRepository extends JpaRepository<Room, Long> {
    @Query("select r from Room r where r.city like ?1")
    List<Room> findByCity(String city);


}