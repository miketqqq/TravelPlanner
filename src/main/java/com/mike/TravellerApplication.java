package com.mike;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@SpringBootApplication
public class TravellerApplication {

	private static final Logger logger = Logger.getLogger("TravellerApplication");

	public static void main(String[] args) {
		SpringApplication.run(TravellerApplication.class, args);

		logger.info("running at http://localhost:5550");

	}

}
