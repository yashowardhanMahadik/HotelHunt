package com.ym.BookingHunt.repository;

import com.ym.BookingHunt.model.Booking;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface BookingRepository extends ReactiveMongoRepository<Booking  , String>{

}
