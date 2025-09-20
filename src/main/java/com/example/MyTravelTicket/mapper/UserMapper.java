package com.example.MyTravelTicket.mapper;

import com.example.MyTravelTicket.dto.UserDto;
import com.example.MyTravelTicket.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public static UserDto toDto(User user){
        UserDto userDto = UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .aadharNumber(user.getAadharNumber())
                .panNumber(user.getPanNumber())
                .address(user.getAddress())
                .createdAt(user.getCreatedAt())
                .build();
        return userDto;
    }

}
