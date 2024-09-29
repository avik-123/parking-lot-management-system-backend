package com.example.parkingApplication.repositories;

import com.example.parkingApplication.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    Vehicle findByRegistrationId(String registrationId);
}