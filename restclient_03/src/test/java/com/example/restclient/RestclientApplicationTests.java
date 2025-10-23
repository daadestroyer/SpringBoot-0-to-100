package com.example.restclient;

import com.example.restclient.clients.HotelClients;
import com.example.restclient.dto.HotelDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class RestclientApplicationTests {

	@Autowired
	HotelClients hotelClients;

	@Test
	void getAllHotels(){
		List<HotelDTO> hotelDTOList = hotelClients.getAllHotels();
		System.out.println(hotelDTOList);
	}
	@Test
	void getHotelById(){
		HotelDTO hotelById = hotelClients.getHotelById(2L);
		System.out.println(hotelById);

	}
}
