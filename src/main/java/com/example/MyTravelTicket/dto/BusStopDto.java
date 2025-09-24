package com.example.MyTravelTicket.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BusStopDto {
    private Long id;
    private String stopName;

    private Boolean isBusStopSource;
    private Boolean isBusStopInMiddle;
    private Boolean isBusStopDestination;

    private Double latitude;
    private Double longitude;

    private Long busStopOrder;

}
