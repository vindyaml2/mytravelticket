package com.example.MyTravelTicket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.MyTravelTicket.entity.Route;
import com.example.MyTravelTicket.service.RouteService;

@RestController
@RequestMapping("/route")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @PostMapping
    private ResponseEntity<?> saveRoute(@RequestBody Route route){
        Route savedRoute = routeService.save(route);
        return new ResponseEntity<>(savedRoute, HttpStatus.CREATED);
    }

    @GetMapping
    private ResponseEntity<?> getAllRoutes(){
        List<Route> allRoute = routeService.getAllRoutes();
        return new ResponseEntity<>(allRoute, HttpStatus.ACCEPTED);
    }

    @DeleteMapping
    private ResponseEntity<?> deleteRoute(@RequestParam Long routeId){
        try{
            routeService.deleteRoute(routeId);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
