package com.example.parkingApplication.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LeaveResponse {
    private String registrationId;
    private double amount;
}
