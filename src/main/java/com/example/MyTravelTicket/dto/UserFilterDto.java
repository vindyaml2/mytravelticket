package com.example.MyTravelTicket.dto;

import com.example.MyTravelTicket.entity.UserType;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserFilterDto {
    private Boolean isOnDuty;
    private UserType userType;
}
