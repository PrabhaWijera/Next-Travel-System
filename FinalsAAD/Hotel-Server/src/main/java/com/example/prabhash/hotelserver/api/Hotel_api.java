package com.example.prabhash.hotelserver.api;


import com.example.prabhash.hotelserver.dto.Hotel_dto;
import com.example.prabhash.hotelserver.fiegn.PackageInterface;
import com.example.prabhash.hotelserver.res.Response;

import com.example.prabhash.hotelserver.service.custom.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("api/v1/hotel")
@RestController
public class Hotel_api {

    Hotel_api(){
        System.out.println("Hotel api class Run!!");
    }

    @Autowired
    private HotelService hotelService;

    @Autowired
    private PackageInterface packageInterface;


    @PostMapping(path = "h_save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response>save( @RequestBody Hotel_dto hotelDto){
        System.out.println("Hotel save working");
        System.out.println("pk id"+hotelDto.getPackageId());
        return hotelService.add(hotelDto);
    }

    @PutMapping(path = "h_put",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> update(@RequestBody Hotel_dto hotelDto){
        System.out.println("Hotel update working");
        return hotelService.update(hotelDto);
    }

    @DeleteMapping(path = "H_Delete",params = "H_ID",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> delete( @RequestParam("H_ID") String H_ID){
        ResponseEntity<Response> response = search(H_ID);
        Hotel_dto hotelDTO = (Hotel_dto) response.getBody().getData();
        hotelService.delete(H_ID);
        return packageInterface.deleteHotelID(hotelDTO.getPackageId(),hotelDTO.getHotelId());
    }
    @GetMapping(path = "/getAllHotels",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response>getAllHotels(){
        return hotelService.getAll();

    }
    @DeleteMapping(path = "/deleteAllHotels",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response>deleteAllHotels(@RequestBody List<String> hotelIDs){
        return hotelService.deleteAllHotels(hotelIDs);

    }

    @GetMapping(path = "/getHotelByHotelName",params = "hotelName",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response>getHotelByName(@RequestParam("hotelName")String hotelName){
        return hotelService.findByHotelName(hotelName);
    }
    @GetMapping(path = "H_search",params = "H_ID",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> search(@RequestParam("H_ID") String H_ID){
        return hotelService.search(H_ID);
    }


    @GetMapping(path = "getHotelByPackageId",params = "packageId",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> getHotelByPackageID(@RequestParam("packageId") String packageId){
        System.out.println("getHotelByPackageID");
        return hotelService.findHotelsByPackagingID(packageId);
    }


}
