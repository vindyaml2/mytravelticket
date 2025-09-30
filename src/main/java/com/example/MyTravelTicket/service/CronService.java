package com.example.MyTravelTicket.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MyTravelTicket.entity.User;
import com.example.MyTravelTicket.repository.UserRepository;

@Service
public class CronService {

    @Autowired
    private UserRepository userRepository;

   public void updateLogOutTimeandOnDutyStatus() {
        // get all users and check their login time and update logout time and on duty status
        List<User> allUsers = userRepository.findAll();
        for(User user: allUsers){
            LocalDateTime currentTime = LocalDateTime.now();
            //if current time is 8 hours after login time then update logout time and on duty status
            if(user.getDayLogInTime() != null && user.getDayLogInTime().plusHours(8).isBefore(currentTime)){
                user.setIsOnDuty(false);
                user.setDayLogOutTime(currentTime);
                userRepository.save(user);
            }
        }
    }
}
