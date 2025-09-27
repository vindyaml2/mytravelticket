package com.example.MyTravelTicket.mapper;

import com.example.MyTravelTicket.dto.BusDto;
import com.example.MyTravelTicket.entity.Bus;
import org.springframework.stereotype.Component;

@Component
public class BusMapper {
    public static BusDto toBusDto(Bus bus){
        BusDto busDto = BusDto.builder()
                .id(bus.getId())
                .registrationNumber(bus.getRegistrationNumber())
                .createdAt(bus.getCreatedAt())
                .isBusOnCoditionAndRunning(bus.getIsBusOnCoditionAndRunning())
                .isOnDuty(bus.getIsOnDuty())
                .build();
        return busDto;
    }
}
