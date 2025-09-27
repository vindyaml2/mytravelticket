package com.example.MyTravelTicket.mapper;

import com.example.MyTravelTicket.dto.BusStopDto;
import com.example.MyTravelTicket.entity.BusStop;
import org.springframework.stereotype.Component;

@Component
public class BusStopMapper {
    public static BusStopDto toBusStopDto(BusStop busStop){
       BusStopDto busStopDto = BusStopDto.builder()
               .id(busStop.getId())
               .stopName(busStop.getStopName())
               .isBusStopSource(busStop.getIsBusStopSource())
               .isBusStopInMiddle(busStop.getIsBusStopInMiddle())
               .isBusStopDestination(busStop.getIsBusStopDestination())

               .latitude(busStop.getLatitude())
               .longitude(busStop.getLongitude())
               .busStopOrder(busStop.getBusStopOrder())
               .build();
       return busStopDto;
    }
}
