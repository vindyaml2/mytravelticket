package com.example.MyTravelTicket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MyTravelTicketApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyTravelTicketApplication.class, args);
	}

}
