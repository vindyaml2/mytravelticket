package com.example.MyTravelTicket.controller;

import java.util.List;

import com.example.MyTravelTicket.dto.BusDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MyTravelTicket.entity.Bus;
import com.example.MyTravelTicket.service.BusService;

@RestController
@RequestMapping("/bus")
public class BusController {
    @Autowired
    private BusService busService;

    @PostMapping
    private ResponseEntity<?> saveBus(@RequestBody Bus bus){
        BusDto savedBus = busService.save(bus);
        return new ResponseEntity<>(savedBus, HttpStatus.CREATED);
    }

    @GetMapping
    private ResponseEntity<?> getAllBuses(){
        List<BusDto> allBuses = busService.getAllBuses();
        return new ResponseEntity<>(allBuses, HttpStatus.OK);
    }
}
