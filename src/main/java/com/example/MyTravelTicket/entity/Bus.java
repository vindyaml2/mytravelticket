package com.example.MyTravelTicket.entity;

import java.time.LocalDateTime;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String registrationNumber;
    
    @OneToOne // Correct way to map the driver
    @JoinColumn(name = "driver_id")
    private User driver;

    @OneToOne // Correct way to map the conductor
    @JoinColumn(name = "conductor_id")
    private User conductor;

    private Boolean isBusOnCoditionAndRunning;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @ManyToMany
    @JoinTable(name = "bus_route_mapper", joinColumns = @JoinColumn(name = "bus_id"), inverseJoinColumns = @JoinColumn(name = "route_id"))
    private Set<Route> route;
}
