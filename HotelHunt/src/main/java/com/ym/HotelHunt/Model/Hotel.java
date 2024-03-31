package com.ym.HotelHunt.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
@Builder
public class Hotel {
    @Id
    String id;

    String hotelName;
    List<Room> rooms;
    String location;
}
