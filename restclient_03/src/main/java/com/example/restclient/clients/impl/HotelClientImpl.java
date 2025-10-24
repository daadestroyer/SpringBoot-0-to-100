package com.example.restclient.clients.impl;

import com.example.restclient.clients.HotelClients;
import com.example.restclient.dto.HotelDTO;
import com.example.restclient.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
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
                .onStatus(HttpStatusCode::is4xxClientError,(req,res)->{
                    throw new ResourceNotFoundException("Hotel with id "+hotelId+" not found");
                })
                .body(new ParameterizedTypeReference<HotelDTO>() {
                });
        return hotelDto;

    }

    @Override
    public HotelDTO createHotel(HotelDTO hotelDTO) {
        try{
            HotelDTO hotelDto = restClient
                    .post()
                    .uri("/api/v1/admin/hotels")
                    .body(hotelDTO)
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError,(req,res)->{
                        throw new ResourceNotFoundException("Could not create hotel");
                    })
                    .body(new ParameterizedTypeReference<HotelDTO>() {
                    });
            return hotelDto;
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteHotel(Long hotelId) {
        try{
            restClient
                    .delete()
                    .uri("/api/v1/admin/hotels/{hotelId}",hotelId)
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError,(req,res)->{
                        throw new ResourceNotFoundException("Hotel with id "+hotelId+" not found");
                    })
                    .toBodilessEntity();
        }
        catch (Exception e){
            throw new RuntimeException("Failed to delete hotel id = "+hotelId);
        }
    }
}
