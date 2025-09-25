package com.example.MyTravelTicket.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@EqualsAndHashCode(exclude = "busStop")
public class Route {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String routeName;
    @ManyToMany(mappedBy = "route")
    @JsonIgnore
    private Set<Bus> bus;

    @ManyToMany(mappedBy = "routeStops")
    @JsonIgnore
    @ToString.Exclude
    private Set<BusStop> busStop;
}
