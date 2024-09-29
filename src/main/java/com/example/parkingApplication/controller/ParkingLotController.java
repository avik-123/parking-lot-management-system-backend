package com.example.parkingApplication.controller;

import com.example.parkingApplication.entity.ParkingLot;
import com.example.parkingApplication.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/parking-lots")
public class ParkingLotController {
    @Autowired
    private ParkingLotService parkingLotService;

    @PostMapping
    public ResponseEntity<ParkingLot> createParkingLot(@RequestBody ParkingLot lot) {
        ParkingLot createdLot = parkingLotService.createParkingLot(lot);
        return ResponseEntity.ok(createdLot);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParkingLot> getParkingLot(@PathVariable Long id) {
        ParkingLot lot = parkingLotService.getParkingLot(id);
        return ResponseEntity.ok(lot);
    }
}
