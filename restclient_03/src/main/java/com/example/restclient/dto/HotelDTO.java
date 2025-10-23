package com.example.restclient.dto;

import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class HotelDTO {
    private long hotelId;
    private String name;
    private String city;
    private String[] photos;
    private String[] amenities;
    @Embedded
    private HotelContactInfoDTO hotelContactInfo;
    private Boolean active;
}
