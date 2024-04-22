package com.ym.BookingHunt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class BookingHuntApplication {
	@Bean
	public WebClient getWebClient(){
		WebClient wclient = WebClient.create();
		return wclient;
	}

	public static void main(String[] args) {
		SpringApplication.run(BookingHuntApplication.class, args);
	}

}
