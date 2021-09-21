package com.SprintProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;

@SpringBootApplication
@Import(SpringDataRestConfiguration.class)
public class OnlineMovieTicketBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineMovieTicketBookingApplication.class, args);
	}

}
