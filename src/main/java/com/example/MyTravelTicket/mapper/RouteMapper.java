package com.example.MyTravelTicket.mapper;

import com.example.MyTravelTicket.dto.RouteDto;
import com.example.MyTravelTicket.entity.Route;
import org.springframework.stereotype.Component;

@Component
public class RouteMapper {
    public static RouteDto toRouteDto(Route route){
        RouteDto routeDto = RouteDto.builder()
                .id(route.getId())
                .routeName(route.getRouteName())
                .build();
        return routeDto;
    }
}
