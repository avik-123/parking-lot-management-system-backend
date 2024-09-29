package com.example.parkingApplication.repositories;

import com.example.parkingApplication.entity.ParkingSpot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingSpotRepository extends JpaRepository<ParkingSpot, Long> {
    ParkingSpot findByLotIdAndSpotNumber(Long lotId, int spotNumber);
}
