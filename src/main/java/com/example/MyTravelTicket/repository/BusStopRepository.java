package com.example.MyTravelTicket.repository;

import com.example.MyTravelTicket.entity.BusStop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusStopRepository extends JpaRepository<BusStop, Long> {
    List<BusStop> findAllByRouteStops_Id(Long routeId);
}
