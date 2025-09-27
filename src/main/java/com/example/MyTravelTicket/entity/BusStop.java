package com.example.MyTravelTicket.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(exclude = "routeStops")
public class BusStop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String stopName;
    @Column
    private Boolean isBusStopSource;
    private Boolean isBusStopInMiddle;
    private Boolean isBusStopDestination;

    private Double latitude;
    private Double longitude;

    private Long busStopOrder;

    @ManyToMany
    @JoinTable(name = "busStop_route_mapper", joinColumns = @JoinColumn(name = "busStop_id"), inverseJoinColumns = @JoinColumn(name = "route_id"))
    @ToString.Exclude
    private Set<Route> routeStops ;
}
