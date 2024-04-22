package com.ym.BookingHunt.client;

import com.ym.BookingHunt.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class UserClient {

    @Autowired
    private WebClient webClient;
    public Mono<User> getUser(String userId){
        return webClient.get()
                .uri("http://localhost:8081/v1/user/{userId}",userId)
                .retrieve()
                .bodyToMono(User.class)
                .log();
    }
}
