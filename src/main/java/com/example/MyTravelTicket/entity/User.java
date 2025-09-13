package com.example.MyTravelTicket.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;


@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName; 
    private String aadharNumber;
    private String panNumber;
    private String address;
    
    @CreationTimestamp   
    private LocalDateTime createdAt;
}
