package com.example.restclient.dto;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class HotelContactInfoDTO {
    private String address;
    private String phoneNumber;
    private String pinCode;
    private String email;
}
