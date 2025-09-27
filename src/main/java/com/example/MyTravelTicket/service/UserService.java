package com.example.MyTravelTicket.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.MyTravelTicket.dto.UserDto;
import com.example.MyTravelTicket.dto.UserFilterDto;
import com.example.MyTravelTicket.mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.MyTravelTicket.entity.User;
import com.example.MyTravelTicket.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    public UserDto saveUser(User user) throws Exception {
        // to set plain password comment below line
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        String panNumber = user.getPanNumber();
        int panNumberLength = panNumber.length();
        if (panNumberLength != 10) {
            throw new Exception("pan Number length should be 10");
        }
        User savedUser = userRepository.save(user);
        UserDto userDto = UserMapper.toDto(savedUser);
        return userDto;
    }

    public List<UserDto> getAllUsers() {
        List<User> allUsers = userRepository.findAll();
        List<User> allUsersWithoutNullValues = new ArrayList<>();
        for (User user : allUsers) {
            if (user.getFirstName() != null) {
                allUsersWithoutNullValues.add(user);
            }
        }
        List<UserDto> allUsersDto = new ArrayList<>();
        for (User user : allUsersWithoutNullValues) {
            UserDto userDto = UserMapper.toDto(user);
            allUsersDto.add(userDto);
        }
        return allUsersDto;
    }

    public UserDto getUserById(Long userId) throws Exception {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) {
            throw new RuntimeException("User not found with id: " + userId);
        }
        User user = userOptional.get();
        UserDto userDto = UserMapper.toDto(user);
        return userDto;
    }

    public List<UserDto> getAllUserOnFilter(UserFilterDto userFilterDto) {
        List<User> filteredUsers = userRepository.findAll();

        // Define a map of predicates for filtering
        List<java.util.function.Predicate<User>> predicates = List.of(
            userFilterDto.getUserType() != null ? user -> user.getUserType().equals(userFilterDto.getUserType()) : user -> true,
            userFilterDto.getIsOnDuty() != null ? user -> user.getIsOnDuty().equals(userFilterDto.getIsOnDuty()) : user -> true
        );

        // Apply all predicates to filter the users
        for (java.util.function.Predicate<User> predicate : predicates) {
            filteredUsers = filteredUsers.stream().filter(predicate).toList();
        }

        // Map filtered users to UserDto
        return filteredUsers.stream()
            .map(UserMapper::toDto)
            .toList();
    }
}
