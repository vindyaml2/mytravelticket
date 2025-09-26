package com.example.MyTravelTicket.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;


@Entity
// @Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    private String password;
    private String aadharNumber;
    private String panNumber;
    private String address;
    
    private UserType userType;
    @CreationTimestamp   
    private LocalDateTime createdAt;
}
