package com.example.MyTravelTicket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.MyTravelTicket.dto.UserDto;
import com.example.MyTravelTicket.entity.User;
import com.example.MyTravelTicket.service.BusConductorService;

@RestController
@RequestMapping("/conductor")
public class BusConductorController {
    
    @Autowired
    private BusConductorService busConductorService;

    @PostMapping
    private ResponseEntity<?> saveBusConductor(@RequestBody User conductor){
        try{
            UserDto savedConductor = busConductorService.saveBusConductor(conductor);
            return ResponseEntity.status(201).body(savedConductor);
        }
        catch(Exception e){
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @GetMapping
    private ResponseEntity<?> getAllBusConductor(){
        List<UserDto> allConductors = busConductorService.getAllBusConductors();
        return ResponseEntity.status(202).body(allConductors);
    }

    @GetMapping("/id")
    private ResponseEntity<?> getBusConductorById(@RequestParam Long busConductorId){
        try{
           UserDto busConductorDto = busConductorService.getBusConductor(busConductorId);
           return ResponseEntity.status(200).body(busConductorDto);
        }
        catch(Exception e){
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}
