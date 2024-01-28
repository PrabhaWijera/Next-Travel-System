package com.example.user_server.user.fiegn;

import com.example.user_server.user.dto.Vehicle_dto;
import com.example.user_server.user.res.Response;
import jakarta.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient("vehicle-server")
public interface VehicleAuthFiegnInterface {



    @GetMapping("/check")
    public String getCheck_vehicle();



    @PostMapping(path = "vSave",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response save(@Valid  @RequestBody Vehicle_dto vehicleDto);

    @PutMapping(path = "/Vput",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response update( @RequestBody Vehicle_dto vehicleDto);

    @DeleteMapping(path = "V_delete",params ="Vehicle_ID",produces = MediaType.APPLICATION_JSON_VALUE)
    public Response delete( @RequestParam("Vehicle_ID") String vehicleID);
    @GetMapping(path = "V_search",params = "Vehicle_ID",produces = MediaType.APPLICATION_JSON_VALUE)
    public Response search( @RequestParam("Vehicle_ID") String Vehicle_ID);

//for package testing

    @PostMapping("/getvehi")
    public ResponseEntity <String> getAllVehicles(@Valid @RequestParam String id);


}
