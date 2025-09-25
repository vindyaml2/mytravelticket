package com.example.MyTravelTicket.service;

import com.example.MyTravelTicket.dto.BusStopDto;
import com.example.MyTravelTicket.entity.Bus;
import com.example.MyTravelTicket.entity.BusStop;
import com.example.MyTravelTicket.entity.Route;
import com.example.MyTravelTicket.mapper.BusStopMapper;
import com.example.MyTravelTicket.repository.BusStopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BusStopService {

    @Autowired
    private BusStopRepository busStopRepository;

    public BusStopDto saveBusStop(BusStop busStop){
        BusStop savedBusStop = busStopRepository.save(busStop);
        BusStopDto busStopDto = BusStopMapper.toBusStopDto(savedBusStop);
        return busStopDto;
    }

    public List<BusStopDto> getAllBusStops() {
        List<BusStop> allBusStop = busStopRepository.findAll();
        List<BusStopDto> allBusStopDto = new ArrayList<>();
        for(BusStop busStop: allBusStop){
            BusStopDto busStopDto = BusStopMapper.toBusStopDto(busStop);
            allBusStopDto.add(busStopDto);
        }
        return allBusStopDto;
    }

    public List<BusStop> getAllBusStopsForRoute(Long routeId) {
        List<BusStop> allBusStopForRoute = busStopRepository.findAllByRouteStops_Id(routeId);
        return allBusStopForRoute;
    }

    public BusStop getBusStop(Long busStopId) throws Exception {
        Optional<BusStop> optionalBusStop = busStopRepository.findById(busStopId);
        if(optionalBusStop.isPresent()){
            return optionalBusStop.get();
        }
        else{
            throw new Exception("busStopId "+busStopId+" not found!");
        }
    }
    public void deleteBusStop(Long busStopId) throws Exception {
        BusStop busStop = getBusStop(busStopId);
        busStopRepository.delete(busStop);
    }

    public void updateBusStop(BusStopDto busStop) throws Exception {
        BusStop savedBusStop = getBusStop(busStop.getId());

        savedBusStop.setStopName(busStop.getStopName());
        savedBusStop.setBusStopOrder(busStop.getBusStopOrder());

        savedBusStop.setIsBusStopDestination(busStop.getIsBusStopDestination());
        savedBusStop.setIsBusStopInMiddle(busStop.getIsBusStopInMiddle());
        savedBusStop.setIsBusStopSource(busStop.getIsBusStopSource());

        savedBusStop.setLatitude(busStop.getLatitude());
        savedBusStop.setLongitude(busStop.getLongitude());

        busStopRepository.save(savedBusStop);
    }

    public BusStopDto getBusStopById(Long busStopId) throws Exception {
        BusStop busStop = getBusStop(busStopId);
        BusStopDto busStopDto = BusStopMapper.toBusStopDto(busStop);
        return busStopDto;
    }
}
