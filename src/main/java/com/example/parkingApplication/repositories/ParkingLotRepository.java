package com.example.parkingApplication.repositories;

import com.example.parkingApplication.entity.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingLotRepository extends JpaRepository<ParkingLot, Long> {}
