package com.ym.BookingHunt.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Room {
    String room_no;
    String type;
    boolean isAvailable;

}
