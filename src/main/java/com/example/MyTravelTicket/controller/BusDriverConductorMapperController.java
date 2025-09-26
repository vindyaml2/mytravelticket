package com.example.MyTravelTicket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MyTravelTicket.dto.BusDriverConductorMappingDto;
import com.example.MyTravelTicket.dto.BusDriverConductorMappingResponseDto;
import com.example.MyTravelTicket.service.BusDriverConductorMapperService;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/bus-driver-conductor-mapper")
public class BusDriverConductorMapperController {
    @Autowired
    private BusDriverConductorMapperService busDriverConductorMapperService;

    @PostMapping
    private ResponseEntity<?> createBusDriverConductorMapping(
            @RequestBody BusDriverConductorMappingDto busConductorDto) {
        try {
            busDriverConductorMapperService.createBusDriverConductorMapping(busConductorDto);
            return ResponseEntity.status(201).body("Mapping created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @GetMapping
    private ResponseEntity<?> getAllBusDriverConductorMappings() throws Exception {
        try {
            List<BusDriverConductorMappingResponseDto> allMappings = busDriverConductorMapperService.getAllMappings();
            return ResponseEntity.status(202).body(allMappings);
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}
