package com.ym.BookingHunt.exception;

public class PaymentFailedException extends RuntimeException{
    public PaymentFailedException(String s) {
        super(s);
    }
}
