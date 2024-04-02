package com.ym.BookingHunt.exception;

public class RoomNotFoundException extends RuntimeException {
    public RoomNotFoundException(String message) { super(message);
    }
}
