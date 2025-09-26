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
public class DriverService {
    @Autowired
    private UserRepository userRepository;

    public UserDto saveDriver(User driver) {
        System.out.println(driver);
        driver.setUserType(UserType.DRIVER);
        User savedDriver = userRepository.save(driver);
        UserDto savedDriverDto = UserMapper.toDto(savedDriver);
        return savedDriverDto;
    }

    public List<UserDto> getAllDrivers() {
        List<User> allDrivers = userRepository.findByUserType(UserType.DRIVER);
        List<UserDto> allDriversDto = allDrivers.stream().map(UserMapper::toDto).toList();
        return allDriversDto;
    }

    public UserDto getDriverById(Long driverId) throws Exception{
        User driver = userRepository.findById(driverId)
                .orElseThrow(() -> new RuntimeException("Driver not found with id: " + driverId));
        UserDto driverDto = UserMapper.toDto(driver);
        return driverDto;
    }
}
