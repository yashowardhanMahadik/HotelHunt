package com.ym.BookingHunt.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
@Builder
@ToString
public class User {

	@Id
	private String id;
	private String name;
	private Address address;
	private Long phoneNumber;
	
	
}
