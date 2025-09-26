package com.example.MyTravelTicket.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BusDriverConductorMappingResponseDto {
    UserDto driverDto;
    UserDto conductorDto;
    BusDto busDto;
    RouteDto routeDto;
}
