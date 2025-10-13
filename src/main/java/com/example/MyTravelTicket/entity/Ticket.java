package com.example.MyTravelTicket.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
// @Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Ticket {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double price;
    private Long busId;
    private Long userId;
    private Long routeId;
    private Long busStopStartPoint;
    private Long busStopEndPoin;

    @CreationTimestamp
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private LocalDate deletedAt;
}
