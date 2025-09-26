package com.example.MyTravelTicket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MyTravelTicket.dto.UserDto;
import com.example.MyTravelTicket.entity.User;
import com.example.MyTravelTicket.service.DriverService;

@RestController
@RequestMapping("/driver")
public class BusDriverController {
    @Autowired
    private DriverService driverService;

    @PostMapping
    public ResponseEntity<?> saveDriver(@RequestBody User driver) {
        try {
            UserDto savedDriverDto = driverService.saveDriver(driver);
            return new ResponseEntity<>(savedDriverDto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    private ResponseEntity<?> getAllDrivers() {
        List<UserDto> allDriversDto = driverService.getAllDrivers();
        return new ResponseEntity<>(allDriversDto, HttpStatus.ACCEPTED);
    }
}
