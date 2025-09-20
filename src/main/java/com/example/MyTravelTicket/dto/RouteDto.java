package com.example.MyTravelTicket.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RouteDto {
    private Long id;
    private String routeName;
}
