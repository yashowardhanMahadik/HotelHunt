package com.ym.HotelHunt.Repository;

import com.ym.HotelHunt.Model.Hotel;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;


public interface HotelRepository extends ReactiveMongoRepository<Hotel, String> {
}
