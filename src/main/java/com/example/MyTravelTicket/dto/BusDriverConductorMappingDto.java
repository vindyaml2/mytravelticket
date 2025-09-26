package com.example.MyTravelTicket.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BusDriverConductorMappingDto {
    private Long driverId;
    private Long conductorId;
    private Long busId;
    private Long routeId;
}
