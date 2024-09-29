package com.example.parkingApplication.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class LeaveRequest {
    private String registrationId;
    private LocalDateTime endTime;
}
