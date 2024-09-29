package com.example.parkingApplication.service;


import com.example.parkingApplication.dto.LeaveRequest;
import com.example.parkingApplication.dto.LeaveResponse;
import com.example.parkingApplication.dto.ParkRequest;
import com.example.parkingApplication.entity.ParkingSpot;
import com.example.parkingApplication.entity.Ticket;
import com.example.parkingApplication.entity.Vehicle;
import com.example.parkingApplication.repositories.ParkingSpotRepository;
import com.example.parkingApplication.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private ParkingSpotRepository parkingSpotRepository;

    public Vehicle parkVehicle(ParkRequest request) {
        ParkingSpot spot = parkingSpotRepository.findByLotIdAndSpotNumber(request.getLotId(), request.getSpotNumber());
        if (!spot.isAvailable()) throw new RuntimeException("Spot not available");

        Vehicle vehicle = new Vehicle();
        vehicle.setRegistrationId(request.getRegistrationId());
        vehicle.setParkingSpot(spot);

        Ticket ticket = new Ticket();
        ticket.setStartTime(request.getStartTime());
        ticket.setVehicle(vehicle);
        vehicle.setTicket(ticket);

        spot.setAvailable(false);
        parkingSpotRepository.save(spot);

        return vehicleRepository.save(vehicle);
    }

    public LeaveResponse leaveVehicle(LeaveRequest request) {
        Vehicle vehicle = vehicleRepository.findByRegistrationId(request.getRegistrationId());
        if (vehicle == null) throw new RuntimeException("Vehicle not found");

        Ticket ticket = vehicle.getTicket();
        ticket.setEndTime(request.getEndTime());

        double fee = ticket.calculateFee();

        ParkingSpot spot = vehicle.getParkingSpot();
        spot.setAvailable(true);
        parkingSpotRepository.save(spot);

        vehicleRepository.delete(vehicle);

        LeaveResponse response = new LeaveResponse();
        response.setRegistrationId(request.getRegistrationId());
        response.setAmount(fee);

        return response;
    }
}
