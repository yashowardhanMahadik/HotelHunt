package com.ym.BookingHunt.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
@Builder
@ToString
public class Hotel {
    @Id
    String id;

    @Indexed(name="hotelName",unique = true)
    String hotelName;
    List<Room> rooms;
    String location;
}
