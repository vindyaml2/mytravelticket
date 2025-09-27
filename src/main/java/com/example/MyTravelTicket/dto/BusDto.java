package com.example.MyTravelTicket.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class BusDto {
    private Long id;
    private String registrationNumber;
    private Boolean isBusOnCoditionAndRunning;
    private LocalDateTime createdAt;
    private Boolean isOnDuty;

    private LocalDateTime updatedAt;
    private LocalDateTime lastServicedAt;

    private LocalDateTime deletedAt;
    private LocalDateTime dayLogInTime;
    private LocalDateTime dayLogOutTime;
}
