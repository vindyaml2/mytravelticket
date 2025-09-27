package com.example.MyTravelTicket.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class BusDriverConductorMapper {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long driverId;
    private Long conductorId;
    private Long busId; 
    private Long routeId;

    private boolean isActive;
    @CreationTimestamp
    private LocalDateTime createdAt;
}
