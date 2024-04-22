package com.ym.BookingHunt.client;

import com.ym.BookingHunt.model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class HotelClient {

    @Autowired
    private WebClient webClient;

    public Mono<Hotel> getHotel(String hotelId){
        return webClient.get()
                .uri("http://localhost:8081/v1/hotel/{hotelId}",hotelId)
                .retrieve()
                .bodyToMono(Hotel.class)
                .log();
    }
}
