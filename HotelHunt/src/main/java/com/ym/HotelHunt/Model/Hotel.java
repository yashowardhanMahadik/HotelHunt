package com.ym.HotelHunt.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
@Builder
public class Hotel {
    @Id
    String id;

    @Indexed(name="hotelName",unique = true)
    String hotelName;
    List<Room> rooms;
    String location;
}
