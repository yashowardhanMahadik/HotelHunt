package com.ym.BookingHunt.router;

import com.ym.BookingHunt.handler.BookingHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class BookingRouter {

    @Bean
    RouterFunction<ServerResponse> createBooking(BookingHandler bookingHandler){
        return route()
                .POST("/booking/id/{id}/hotelName/{name}/room/{type}", req -> bookingHandler
                        .createBooking(req.pathVariable("id"), req.pathVariable("name"), req.pathVariable("type")))
                .build();

    }
}
