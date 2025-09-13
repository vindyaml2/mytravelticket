package com.example.MyTravelTicket.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MyTravelTicket.entity.User;
import com.example.MyTravelTicket.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) throws Exception{
        String panNumber = user.getPanNumber();
        int panNumberLength = panNumber.length();
        if(panNumberLength != 10){
            throw new Exception("pan Number length should be 10");
        }
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    public List<User> getAllUsers() {
        List<User> allUsers = userRepository.findAll();
        List<User> allUsersWithoutNullValues = new ArrayList<>();
        for(User user : allUsers){
            if (user.getFirstName() != null){
                allUsersWithoutNullValues.add(user);
            }
        }
        return allUsersWithoutNullValues;
    }
}
