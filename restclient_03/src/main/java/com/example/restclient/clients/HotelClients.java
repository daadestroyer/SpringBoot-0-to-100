package com.example.restclient.clients;

import com.example.restclient.dto.HotelDTO;

import java.util.List;

public interface HotelClients {
    List<HotelDTO> getAllHotels();
    HotelDTO getHotelById(Long hotelId);
    HotelDTO createHotel(HotelDTO hotelDTO);
    void deleteHotel(Long hotelId);
}

