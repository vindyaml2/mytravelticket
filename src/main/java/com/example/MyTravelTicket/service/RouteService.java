package com.example.MyTravelTicket.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.MyTravelTicket.dto.BusStopDto;
import com.example.MyTravelTicket.dto.RouteDto;
import com.example.MyTravelTicket.entity.BusStop;
import com.example.MyTravelTicket.mapper.BusStopMapper;
import com.example.MyTravelTicket.mapper.RouteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MyTravelTicket.entity.Route;
import com.example.MyTravelTicket.repository.RouteRepository;

@Service
public class RouteService {
    
    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private BusStopService busStopService;

    public RouteDto save(Route route){
        Route savedRoute = routeRepository.save(route);
        RouteDto routeDto = RouteMapper.toRouteDto(savedRoute);
        return routeDto;
    }

    public List<RouteDto> getAllRoutes() {
        List<Route> allRoutes = routeRepository.findAll();
        List<RouteDto> allRouteDto = new ArrayList<>();
        for(Route route: allRoutes){
            RouteDto routeDto = RouteMapper.toRouteDto(route);
            allRouteDto.add(routeDto);
        }
        return allRouteDto;
    }

    public Route getRoute(Long routeId){
        Optional<Route> savedRoute = routeRepository.findById(routeId);
        if(savedRoute.isPresent()){
            return savedRoute.get();
        }
        return null;
    }

    public void deleteRoute(Long routeId) throws Exception {
        Route savedRoute = getRoute(routeId);
        if(savedRoute != null){
            routeRepository.delete(savedRoute);
            return;
        }
        throw new Exception("route not found for given routeId");
    }

    public List<BusStopDto> getAllBusStopsForRoute(Long routeId) {
        List<BusStop> allBusStopsByRoute = busStopService.getAllBusStopsForRoute(routeId);
        List<BusStopDto> allBusStopByRouteDto = new ArrayList<>();
        for (BusStop busStop: allBusStopsByRoute){
            BusStopDto busStopDto = BusStopMapper.toBusStopDto(busStop);
            allBusStopByRouteDto.add(busStopDto);
        }
        return allBusStopByRouteDto;
    }
}
