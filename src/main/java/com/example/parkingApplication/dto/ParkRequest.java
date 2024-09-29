package com.example.parkingApplication.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class ParkRequest {
    private Long lotId;
    private int spotNumber;
    private String registrationId;
    private LocalDateTime startTime;
}
