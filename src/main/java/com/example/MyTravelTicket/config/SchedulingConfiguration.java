package com.example.MyTravelTicket.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.MyTravelTicket.service.CronService;

@Component
public class SchedulingConfiguration {

    // Assuming you have a dependency injected service
    @Autowired
    private CronService cronService; 

    // public SchedulingConfiguration(CronService cronService) {
    //     this.cronService = cronService;
    // }

    // --- Job 1: Runs every 1 minute ---
    /**
     * This task runs every minute (at the 0th second of every minute).
     * Cron expression: "0 * * * * *"
     */
    @Scheduled(cron = "0 * * * * *")
    public void scheduledTaskEveryMinute() {
        System.out.println("Running the task that executes every minute...");
        cronService.updateTicketToRideComplete();
    }


    // --- Job 2: Runs every 1 hour ---
    /**
     * This task runs every hour (at the top of the hour, e.g., 8:00:00, 9:00:00).
     * Cron expression: "0 0 * * * *"
     */
    @Scheduled(cron = "0 0 * * * *")
    public void scheduledTaskEveryHour() {
        System.out.println("Running the task that executes every hour...");
        cronService.updateLogOutTimeandOnDutyStatus(); 
    }
}