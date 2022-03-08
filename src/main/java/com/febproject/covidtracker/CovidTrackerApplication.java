package com.febproject.covidtracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import java.io.IOException;

@SpringBootApplication
@EnableScheduling		//so that spring knows that scheduling needs to be done
public class CovidTrackerApplication {

	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(CovidTrackerApplication.class, args);
	}

}
