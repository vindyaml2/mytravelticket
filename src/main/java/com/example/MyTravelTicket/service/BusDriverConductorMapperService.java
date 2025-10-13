package com.example.MyTravelTicket.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MyTravelTicket.dto.BusDriverConductorMappingDto;
import com.example.MyTravelTicket.dto.BusDriverConductorMappingResponseDto;
import com.example.MyTravelTicket.dto.BusDto;
import com.example.MyTravelTicket.dto.RouteDto;
import com.example.MyTravelTicket.dto.UserDto;
import com.example.MyTravelTicket.entity.BusDriverConductorMapper;
import com.example.MyTravelTicket.repository.BusDriverConductorMapperRepository;

@Service
public class BusDriverConductorMapperService {

    @Autowired
    private BusDriverConductorMapperRepository busDriverConductorMapperRepository;

    @Autowired
    private DriverService driverService;

    @Autowired
    private BusConductorService busConductorService;

    @Autowired
    private BusService busService;

    @Autowired
    private RouteService routeService;

    public void updateUserLoginTimeAndOnDutyStatus(Long driverId, Long conductorId, Long busId) throws Exception {
        try {
            driverService.updateDriverLoginTimeAndOnDutyStatus(driverId);
            busConductorService.updateBusConductorLoginTimeAndOnDutyStatus(conductorId);
            busService.updateBusLoginAndLogOutStatus(busId);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    public void updateBusOnDuty(Long busId) throws Exception {
        try {
            busService.updateBusOnDutyStatus(busId);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    public void createBusDriverConductorMapping(BusDriverConductorMappingDto busConductorDto) throws Exception {
        try {
            UserDto busDriver = driverService.getDriverById(busConductorDto.getDriverId());
            UserDto busConductor = busConductorService.getBusConductor(busConductorDto.getConductorId());
            BusDto busDto = busService.getBusById(busConductorDto.getBusId());
            RouteDto route = routeService.getRouteDto(busConductorDto.getRouteId());

            BusDriverConductorMapper busDriverConductorMapper = new BusDriverConductorMapper();
            busDriverConductorMapper.setBusId(busDto.getId());
            busDriverConductorMapper.setConductorId(busConductor.getId());
            busDriverConductorMapper.setDriverId(busDriver.getId());
            busDriverConductorMapper.setRouteId(route.getId());

            updateUserLoginTimeAndOnDutyStatus(busDriver.getId(), busConductor.getId(), busDto.getId());
            updateBusOnDuty(busDto.getId());
            busDriverConductorMapperRepository.save(busDriverConductorMapper);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<BusDriverConductorMappingResponseDto> getAllMappings() throws Exception {
        List<BusDriverConductorMapper> allMappings = busDriverConductorMapperRepository.findAll();
        List<BusDriverConductorMappingResponseDto> allMappingsResponseDto = new ArrayList<>();
        for (BusDriverConductorMapper mapping : allMappings) {
            UserDto driver = driverService.getDriverById(mapping.getDriverId());
            UserDto conductor = busConductorService.getBusConductor(mapping.getConductorId());
            BusDto bus = busService.getBusById(mapping.getBusId());
            RouteDto route = routeService.getRouteDto(mapping.getRouteId());
            BusDriverConductorMappingResponseDto responseDto = BusDriverConductorMappingResponseDto.builder()
                    .busDto(bus)
                    .conductorDto(conductor)
                    .driverDto(driver)
                    .routeDto(route)
                    .build();
            allMappingsResponseDto.add(responseDto);
        }


        return allMappingsResponseDto;
    }

}
