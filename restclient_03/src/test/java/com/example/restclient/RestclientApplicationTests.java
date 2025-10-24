package com.example.restclient;

import com.example.restclient.clients.HotelClients;
import com.example.restclient.dto.HotelContactInfoDTO;
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
    void getAllHotels() {
        List<HotelDTO> hotelDTOList = hotelClients.getAllHotels();
        System.out.println(hotelDTOList);
    }
    @Test
    void getHotelById() {
        HotelDTO hotelById = hotelClients.getHotelById(20L);
        System.out.println(hotelById);
    }
    @Test
    void createNewHotel() {
        HotelDTO hotelDTO = HotelDTO
                .builder()
                .name("Landmark Hotel")
                .photos(new String[]{"https://surl.li/xrakdm"})
                .amenities(new String[]{"AC", "BAR", "POOL"})
                .hotelContactInfo(new HotelContactInfoDTO("Kanpur", "333333333", "208006", "landmark@gmail.com"))
                .build();
        hotelClients.createHotel(hotelDTO);
    }
    @Test
    void deleteHotel(){
        hotelClients.deleteHotel(40L);
    }
}
