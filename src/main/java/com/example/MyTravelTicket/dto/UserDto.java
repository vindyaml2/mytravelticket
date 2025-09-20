package com.example.MyTravelTicket.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class UserDto {

    private Long id;

    private String firstName;
    private String lastName;
    private String aadharNumber;
    private String panNumber;
    private String address;

    private LocalDateTime createdAt;
}
