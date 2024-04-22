package com.ym.BookingHunt.handler;

import com.ym.BookingHunt.client.HotelClient;
import com.ym.BookingHunt.client.UserClient;
import com.ym.BookingHunt.exception.PaymentFailedException;
import com.ym.BookingHunt.exception.RoomNotFoundException;
import com.ym.BookingHunt.model.*;
import com.ym.BookingHunt.repository.BookingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class BookingHandler {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    PaymentHandler paymentHandler;

    @Autowired
    private UserClient userClient;

    public Mono<ServerResponse> createBooking(@PathVariable("id")String id, @PathVariable("name")String name,@PathVariable("type")String type) {

        //get user1 details //todo
        User user1 = User.builder().id("1").name("YAshow").address(new Address("as","Indore",Long.valueOf(123131))).build();
        Mono<User> userMono = Mono.just(user1);
        userMono = userClient.getUser("660919b47ff34a0caf8e2320");
        //get hotel details //todo
        Hotel hotel1 = Hotel.builder().hotelName("Marquis").id("1").location("Mumbai")
                .rooms(List.of(new Room("1","Single",true)
                ,new Room("2","Single",false)
                ,new Room("3","Double",true))).build();
        Mono<Hotel> hotelMono = Mono.just(hotel1);
        // merge and create booking
        return Mono.zip(userMono,hotelMono)
                .flatMap(tuple ->{
                    User u1 = tuple.getT1();
                    Hotel h1 = tuple.getT2();
                    log.info("User info fetched: "+ u1);
                    log.info("Hotel info fetched: "+ h1);

                    List<Room> r1 = h1.getRooms();
                    return paymentHandler.processPayment(new Payment("1", "1", 7000)).flatMap(status -> {
                                if (!status)
                                    return Mono.error(new PaymentFailedException("Payment method failed, booking failed!"));
                                else {

                                    Optional<Room> optionalRoom = r1.stream().filter(Room::isAvailable).filter(room -> room.getType().equalsIgnoreCase(type)).findAny();
                                    return getBookingResponse(optionalRoom, u1);
                                }
                            }

                    );


                });
    }

    private Mono<ServerResponse> getBookingResponse(Optional<Room> optionalRoom, User u1) {
        if(optionalRoom.isPresent()){
            Booking bookingCreated = Booking.builder().user(u1).room(optionalRoom.get()).build();
            Mono<Booking> savedBooking = bookingRepository.save(bookingCreated);
            return ServerResponse.ok().body(savedBooking, Booking.class).log();
        }
        else {
            log.error("Unable to create new booking as room type not available.");
            return Mono.error(new RoomNotFoundException("Selected room type not available !"));
        }
    }
}
