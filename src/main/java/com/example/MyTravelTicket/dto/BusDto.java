package com.example.MyTravelTicket.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Data
public class BusDto {
    private Long id;
    private String registrationNumber;
    private Boolean isBusOnCoditionAndRunning;
    private LocalDateTime createdAt;
}
