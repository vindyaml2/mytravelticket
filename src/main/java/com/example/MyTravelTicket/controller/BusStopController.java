package com.example.MyTravelTicket.controller;

import com.example.MyTravelTicket.dto.BusStopDto;
import com.example.MyTravelTicket.entity.BusStop;
import com.example.MyTravelTicket.service.BusStopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bus-stop")
public class BusStopController {
    @Autowired
    private BusStopService busStopService;

    @PostMapping
    private ResponseEntity<?> saveBusStop(@RequestBody BusStop busStop){
        BusStopDto busStopDto = busStopService.saveBusStop(busStop);
        return new ResponseEntity<>(busStopDto, HttpStatus.CREATED);
    }

    @GetMapping
    private ResponseEntity<?> getAllBusStops(){
        List<BusStopDto> allBusStopDto = busStopService.getAllBusStops();
        return new ResponseEntity<>(allBusStopDto, HttpStatus.OK);
    }

    @GetMapping("/id")
    private ResponseEntity<?> getBusStopById(@RequestParam Long busStopId) throws Exception {
        try {
            BusStopDto busStopDto = busStopService.getBusStopById(busStopId);
            return new ResponseEntity<>(busStopDto, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping
    private ResponseEntity<?> updateBusStop(@RequestBody BusStopDto busStop){
        try {
            busStopService.updateBusStop(busStop);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping
    private ResponseEntity<?> deleteBusStop(@RequestParam Long busStopId){
        try {
            busStopService.deleteBusStop(busStopId);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Deleted", HttpStatus.NO_CONTENT);
    }
}
