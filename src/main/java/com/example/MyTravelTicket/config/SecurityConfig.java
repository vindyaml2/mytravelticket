package com.example.MyTravelTicket.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.MyTravelTicket.service.CronService;
import com.example.MyTravelTicket.service.UserService;

@Configuration
public class SecurityConfig  implements WebMvcConfigurer{
    @Autowired
    private CronService cronService;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*");
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    // every 1 hour
    @Scheduled(cron = "0 0 * * * *")
    public void scheduledTask() {
        System.out.println("Auto update logout time and on duty status task started");
        cronService.updateLogOutTimeandOnDutyStatus();
    }
}