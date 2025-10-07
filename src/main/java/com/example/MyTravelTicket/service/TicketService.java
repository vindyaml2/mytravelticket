package com.example.MyTravelTicket.service;

import java.util.List;

import com.example.MyTravelTicket.dto.BusStopDto;
import com.example.MyTravelTicket.dto.RouteDto;
import com.example.MyTravelTicket.entity.BusStop;
import com.example.MyTravelTicket.entity.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MyTravelTicket.entity.Ticket;
import com.example.MyTravelTicket.repository.TicketRepository;
import java.math.BigDecimal;

@Service
public class TicketService {
    
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private RouteService routeService;

    @Autowired
    private BusStopService busStopService;

    public Ticket save(Ticket ticket){
        return ticketRepository.save(ticket);
    }

    public List<Ticket> getAllTickets(){
        return ticketRepository.findAll();
    }

    public BigDecimal calculateTicketPrice(Ticket ticket) throws Exception {
        Long routeId = ticket.getRouteId();
//        RouteDto routeDto = routeService.getRouteDto(routeId);

        Long startPoint = ticket.getBusStopStartPoint();
        BusStop startBusStopPoint = busStopService.getBusStop(startPoint);

        Long endPoint = ticket.getBusStopEndPoin();
        BusStop endBusStopPoint = busStopService.getBusStop(endPoint);

        Long totalNumberOfStops = Math.abs(startBusStopPoint.getBusStopOrder() - endBusStopPoint.getBusStopOrder());
        return getCostByStops(totalNumberOfStops);
    }

    private BigDecimal getCostByStops(Long totalNumberOfStops) {
        if(totalNumberOfStops < 3){
            return new BigDecimal( "6.00");
        }
        else if(totalNumberOfStops <= 6){
            return new BigDecimal("12.00");
        }
        else if(totalNumberOfStops <= 12){
            return new BigDecimal("18.00");
        }
        else{
            return new BigDecimal("25.00");
        }
    }

}
