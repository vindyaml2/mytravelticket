package com.example.MyTravelTicket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MyTravelTicket.entity.User;
import com.example.MyTravelTicket.entity.UserType;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    List<User> findByUserType(UserType driver);

    
}