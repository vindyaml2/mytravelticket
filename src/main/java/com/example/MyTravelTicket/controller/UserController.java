package com.example.MyTravelTicket.controller;

import java.util.List;

import com.example.MyTravelTicket.dto.UserDto;
import com.example.MyTravelTicket.dto.UserFilterDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MyTravelTicket.entity.User;
import com.example.MyTravelTicket.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    
    @PostMapping
    ResponseEntity<?> saveuser(@RequestBody User user){
        UserDto savedUser = null;
        try{
           savedUser = userService.saveUser(user);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping
    ResponseEntity<?> getAllUsers(){
        List<UserDto> allUsers = userService.getAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.ACCEPTED);
    }

    @GetMapping("/id")
    ResponseEntity<?> getUserById(Long userId){
        UserDto user = null;
        try{
            user = userService.getUserById(userId);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    }
    @GetMapping("/filter")
    private ResponseEntity<?> getAllUserByFilter(@ModelAttribute UserFilterDto userFilterDto) {
        try {
            List<UserDto> driversNotOnDuty = userService.getAllUserOnFilter(userFilterDto);
            return new ResponseEntity<>(driversNotOnDuty, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
