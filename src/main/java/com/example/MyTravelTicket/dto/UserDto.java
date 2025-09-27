package com.example.MyTravelTicket.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import com.example.MyTravelTicket.entity.UserType;

@Builder
@Data
public class UserDto {

    private Long id;

    private String firstName;
    private String lastName;
    private String aadharNumber;
    private String panNumber;
    private String address;
    private UserType userType;
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
    private LocalDateTime lastServicedAt;

    private LocalDateTime deletedAt;
    private LocalDateTime dayLogInTime;
    private LocalDateTime dayLogOutTime;
    private boolean isOnDuty;
}
