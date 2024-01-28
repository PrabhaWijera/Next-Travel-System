package com.example.user_server.user.endpointother;

import com.example.user_server.user.dto.Vehicle_dto;
import com.example.user_server.user.fiegn.VehicleAuthFiegnInterface;
import com.example.user_server.user.res.Response;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin
@RequestMapping("api/v1/vehicle_api")
@RestController
public class Vehicle_api {


    @Autowired
    private VehicleAuthFiegnInterface vehicleAuthFiegnInterface;



    @GetMapping("/check")
    public String getCheck_vehicle(){
        return "Vehicle API run";
    }


    @PostMapping(path = "vSave",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response save(@Valid  @RequestBody Vehicle_dto vehicleDto){
        System.out.println("vehicle save working");
        return vehicleAuthFiegnInterface.save(vehicleDto);
    }

    @PutMapping(path = "/Vput",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response update(@RequestBody Vehicle_dto vehicleDto){
        System.out.println("VehicleDto update working in user");
        System.out.println(vehicleDto.toString());
        return vehicleAuthFiegnInterface.update(vehicleDto);
    }


    @DeleteMapping(path = "V_delete",params ="Vehicle_ID",produces = MediaType.APPLICATION_JSON_VALUE)
    public Response delete( @RequestParam("Vehicle_ID") String vehicleID){
        return vehicleAuthFiegnInterface.delete(vehicleID);
    }

    @GetMapping(path = "V_search",params = "Vehicle_ID",produces = MediaType.APPLICATION_JSON_VALUE)
    public Response search( @RequestParam("Vehicle_ID") String Vehicle_ID){
        return  vehicleAuthFiegnInterface.search(Vehicle_ID);
    }

//for package testing

    @PostMapping("/getvehi")
    public ResponseEntity <String> getAllVehicles( @RequestParam String id) {
        // Return the data as a response
        return ResponseEntity.ok(id);
    }



}
