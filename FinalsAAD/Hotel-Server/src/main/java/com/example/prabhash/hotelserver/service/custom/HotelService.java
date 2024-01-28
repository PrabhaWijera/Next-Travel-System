package com.example.prabhash.hotelserver.service.custom;


import com.example.prabhash.hotelserver.dto.Hotel_dto;
import com.example.prabhash.hotelserver.res.Response;
import com.example.prabhash.hotelserver.service.SuperService;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface HotelService extends SuperService<Hotel_dto,String> {
    ResponseEntity<Response>deleteAllHotels(List<String> hotelIDList);
    ResponseEntity<Response> findByHotelName(String hotelName);


    ResponseEntity<Response> findHotelsByPackagingID(String packageId);
}
