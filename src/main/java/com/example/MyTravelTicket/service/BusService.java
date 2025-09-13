package com.example.MyTravelTicket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MyTravelTicket.entity.Bus;
import com.example.MyTravelTicket.repository.BusRepository;

@Service
public class BusService {
    @Autowired
    private BusRepository busRepository;

    public Bus save(Bus bus){
        Bus savedBus = busRepository.save(bus);
        return savedBus;
    }

    public List<Bus> getAllBuses() {
       List<Bus> allBuses = busRepository.findAll();
       return allBuses;
    } 
}
