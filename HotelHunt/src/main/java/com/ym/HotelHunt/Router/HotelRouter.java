package com.ym.HotelHunt.Router;

import com.ym.HotelHunt.Handler.HotelHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.path;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class HotelRouter {

    @Bean
    public RouterFunction<ServerResponse> hotelsRouter(HotelHandler hotelHandler){
        return
                route()
                        .nest(path("/v1/hotel"),builder ->
                            builder
                                    .GET("",hotelHandler::getHotels)
                                    .POST("",hotelHandler::addHotel)
                                    .GET("/{id}",hotelHandler::getHotelById)
                        )

                        .build();
    }
}
