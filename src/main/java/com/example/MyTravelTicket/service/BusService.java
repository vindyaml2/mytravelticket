package com.example.MyTravelTicket.service;

import java.util.ArrayList;
import java.util.List;

import com.example.MyTravelTicket.dto.BusDto;
import com.example.MyTravelTicket.mapper.BusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MyTravelTicket.entity.Bus;
import com.example.MyTravelTicket.repository.BusRepository;

@Service
public class BusService {
    @Autowired
    private BusRepository busRepository;


    public BusDto save(Bus bus){
        Bus savedBus = busRepository.save(bus);
        BusDto busDto = BusMapper.toBusDto(savedBus);
        return busDto;
    }

    public List<BusDto> getAllBuses() {
       List<Bus> allBuses = busRepository.findAll();
       List<BusDto> allBusesDto = new ArrayList<>();
       for(Bus bus: allBuses){
           BusDto busDto = BusMapper.toBusDto(bus);
           allBusesDto.add(busDto);
       }
       return allBusesDto;
    }

    public BusDto getBusById(Long busId) throws Exception {
        Bus bus = busRepository.findById(busId).orElseThrow(()-> new RuntimeException("Bus not found with id: " + busId));
        BusDto busDto = BusMapper.toBusDto(bus);
        return busDto;
    } 
}
