package com.example.MyTravelTicket.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BusFilterDto {
    private Boolean isOnDuty;
}
