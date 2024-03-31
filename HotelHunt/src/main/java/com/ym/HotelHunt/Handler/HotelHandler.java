package com.ym.HotelHunt.Handler;

import com.ym.HotelHunt.Model.Hotel;
import com.ym.HotelHunt.Repository.HotelRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class HotelHandler {

    @Autowired
    private HotelRepository hotelRepository;


    public Mono<ServerResponse> getHotels(ServerRequest request){
        log.info("Get list of hotels");
        var hotels = hotelRepository.findAll();
        return ServerResponse.ok().body(hotels, Hotel.class)
                .switchIfEmpty(Mono.error(new Exception("Unable to find hotel")));
    }

    public Mono<ServerResponse> addHotel(ServerRequest request){
        log.info("Add hotel");
        return request.bodyToMono(Hotel.class)
                .flatMap(hotelRepository::save)
                .flatMap(
                        hotel ->
                                ServerResponse.status(HttpStatus.CREATED)
                                        .bodyValue(hotel)

                ).switchIfEmpty(Mono.error(new Exception("Unable to create new Hotel")));
    }
}
