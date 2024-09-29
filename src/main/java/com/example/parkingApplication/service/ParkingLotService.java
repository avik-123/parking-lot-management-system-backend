package com.example.parkingApplication.service;

import com.example.parkingApplication.entity.ParkingLot;
import com.example.parkingApplication.repositories.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkingLotService {
    @Autowired
    private ParkingLotRepository parkingLotRepository;

    public ParkingLot createParkingLot(ParkingLot lot) {
        return parkingLotRepository.save(lot);
    }

    public ParkingLot getParkingLot(Long id) {
        return parkingLotRepository.findById(id).orElseThrow(() -> new RuntimeException("Parking Lot not found"));
    }}
