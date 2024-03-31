package com.ym.HotelHunt.Repository;

import com.ym.HotelHunt.Model.Hotel;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;


public interface HotelRepository extends ReactiveMongoRepository<Hotel, String> {
    public Mono<Hotel> getHotelByHotelName(String id);
}
