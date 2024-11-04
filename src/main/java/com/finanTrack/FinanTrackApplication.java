package com.finanTrack;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.finanTrack")
public class FinanTrackApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinanTrackApplication.class,args);

	}

}