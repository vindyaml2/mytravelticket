package com.example.MyTravelTicket.controller;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MyTravelTicket.entity.Ticket;
import com.example.MyTravelTicket.service.TicketService;
import java.math.BigDecimal;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RequestMapping("/ticket")
@RestController
public class TicketController {
    
    @Autowired
    private TicketService ticketService;

    @PostMapping
    private ResponseEntity<?> createTicket(@RequestBody Ticket ticket){
        Ticket savedTicket = ticketService.save(ticket);
        return ResponseEntity.status(200).body(savedTicket);
    }
    @GetMapping
    private ResponseEntity<?> getAllTickets(){
        return ResponseEntity.status(202).body(ticketService.getAllTickets());
    }

    @GetMapping("/price")
    private ResponseEntity<?> getTicketPrice(@RequestBody Ticket ticket) throws Exception {
        BigDecimal price = ticketService.calculateTicketPrice(ticket);
        return new ResponseEntity<>(price, HttpStatus.ACCEPTED);
    }
}
