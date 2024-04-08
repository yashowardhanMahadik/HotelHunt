package com.ym.BookingHunt.handler;

import com.ym.BookingHunt.model.Payment;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class PaymentHandler {
    public Mono<Boolean> processPayment(Payment payment) {

        return Mono.just(payment.getAmount() > 0);
    }
}
