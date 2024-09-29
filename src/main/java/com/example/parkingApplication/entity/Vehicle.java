package com.example.parkingApplication.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String registrationId;

    @OneToOne
    @JoinColumn(name = "spot_id")
    private ParkingSpot parkingSpot;

    @OneToOne(mappedBy = "vehicle", cascade = CascadeType.ALL)
    private Ticket ticket;
}
