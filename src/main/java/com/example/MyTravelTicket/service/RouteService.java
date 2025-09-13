package com.example.MyTravelTicket.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MyTravelTicket.entity.Route;
import com.example.MyTravelTicket.repository.RouteRepository;

@Service
public class RouteService {
    
    @Autowired
    private RouteRepository routeRepository;

    public Route save(Route route){
        Route savedRoute = routeRepository.save(route);
        return savedRoute;
    }

    public List<Route> getAllRoutes() {
        List<Route> allRoutes = routeRepository.findAll();
        return allRoutes;
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
}
