package com.example.restclient.clients.impl;

import com.example.restclient.clients.HotelClients;
import com.example.restclient.dto.HotelDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class HotelClientImpl implements HotelClients {

    @Autowired
    private RestClient restClient;

    @Override
    public List<HotelDTO> getAllHotels() {
        try {
            List<HotelDTO> hotelList = restClient
                    .get()
                    .uri("/api/v1/admin/hotels")
                    .retrieve()
                    .body(new ParameterizedTypeReference<List<HotelDTO>>() {
                    });

            return hotelList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public HotelDTO getHotelById(Long hotelId) {
        HotelDTO hotelDto = restClient
                .get()
                .uri("/api/v1/admin/hotels/{hotelId}", hotelId)
                .retrieve()
                .body(new ParameterizedTypeReference<HotelDTO>() {
                });
        return hotelDto;

    }
}
