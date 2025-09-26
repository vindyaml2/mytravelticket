package com.example.MyTravelTicket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MyTravelTicket.dto.UserDto;
import com.example.MyTravelTicket.entity.User;
import com.example.MyTravelTicket.entity.UserType;
import com.example.MyTravelTicket.mapper.UserMapper;
import com.example.MyTravelTicket.repository.UserRepository;

@Service
public class BusConductorService {

    @Autowired
    private UserRepository userRepository;

    public UserDto saveBusConductor(User conductor) {
        conductor.setUserType(UserType.CONDUCTOR);
        User savedConductor = userRepository.save(conductor);
        UserDto savedBusConductorDto = UserMapper.toDto(savedConductor);
        return savedBusConductorDto;
    }

    public List<UserDto> getAllBusConductors() {
        List<User> allConductors = userRepository.findByUserType(UserType.CONDUCTOR);
        List<UserDto> allConductorsDto = allConductors.stream()
                .map(UserMapper::toDto)
                .toList();
        return allConductorsDto;
    }

    public UserDto getBusConductor(Long busConductorId) throws Exception {
        User conductor = userRepository.findById(busConductorId)
                .orElseThrow(() -> new RuntimeException("Bus Conductor not found with id: " + busConductorId));
        UserDto conductorDto = UserMapper.toDto(conductor);
        return conductorDto;
    }
}
