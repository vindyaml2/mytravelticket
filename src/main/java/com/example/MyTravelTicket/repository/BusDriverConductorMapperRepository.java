package com.example.MyTravelTicket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MyTravelTicket.entity.BusDriverConductorMapper;

@Repository
public interface BusDriverConductorMapperRepository extends JpaRepository<BusDriverConductorMapper, Long> {

}
