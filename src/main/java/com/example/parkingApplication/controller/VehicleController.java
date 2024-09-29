package com.example.parkingApplication.controller;

import com.example.parkingApplication.dto.LeaveRequest;
import com.example.parkingApplication.dto.LeaveResponse;
import com.example.parkingApplication.dto.ParkRequest;
import com.example.parkingApplication.entity.Vehicle;
import com.example.parkingApplication.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/park")
    public ResponseEntity<Vehicle> parkVehicle(@RequestBody ParkRequest request) {
        Vehicle vehicle = vehicleService.parkVehicle(request);
        return ResponseEntity.ok(vehicle);
    }

    @PostMapping("/leave")
    public ResponseEntity<LeaveResponse> leaveVehicle(@RequestBody LeaveRequest request) {
        LeaveResponse response = vehicleService.leaveVehicle(request);
        return ResponseEntity.ok(response);
    }
}
