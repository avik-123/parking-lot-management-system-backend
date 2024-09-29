package com.example.parkingApplication.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ParkingSpot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int spotNumber;

    private boolean isAvailable;

    @ManyToOne
    @JoinColumn(name = "lot_id")
    private ParkingLot parkingLot;

    @OneToOne(mappedBy = "parkingSpot", cascade = CascadeType.ALL)
    private Vehicle vehicle;

}
