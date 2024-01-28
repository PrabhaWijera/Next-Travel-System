package com.example.prabhash.packagedetailsserver.api;


import com.example.prabhash.packagedetailsserver.dto.PackageDetails_dto;
import com.example.prabhash.packagedetailsserver.res.Response;
import com.example.prabhash.packagedetailsserver.service.PackageDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("api/v1/packageDetals")
@RestController
public class PackageDetails_api {

    @Autowired
    private PackageDetailsService packageDetailsService;


    @GetMapping("check")
    public String getCheck(){
        return "Checked OK packageDetails";
    }

    @PostMapping(path = "save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> save(@RequestBody PackageDetails_dto packageDetailsDto){
        System.out.println("package save-------------------------");
        return packageDetailsService.save(packageDetailsDto);
    }

    @PutMapping(path = "put",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> update(@RequestBody PackageDetails_dto packageDetailsDto){
        System.out.println("package update-------------------------");
        return packageDetailsService.update(packageDetailsDto);
    }


    @DeleteMapping(path = "delete",params = "PkID",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> delete(@RequestParam("PkID") String PkID){
        System.out.println("package delete-------------------------");
        return packageDetailsService.delete(PkID);
    }

    @GetMapping(path = "get",params = "PkID",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> search(@RequestParam("PkID")String PkID){
        System.out.println("package search-------------------------");
        return packageDetailsService.search(PkID);
    }
    @GetMapping(path = "/getAllPackages",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <Response> getAll() {
        // Return the data as a response
        return packageDetailsService.getAll();
    }
//get package ID
    @GetMapping(path = "/allIDs",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Integer> getAllIDs(){
        return packageDetailsService.getAllID();
    }
    //others

    @PostMapping(path = "/saveHotelID",produces = MediaType.APPLICATION_JSON_VALUE,params = {"packageID","hotelID"})
    public ResponseEntity<Response> saveHotelID(@RequestParam("packageID") String packageID, @RequestParam("hotelID") String hotelID){
        return null;
    }
    @PostMapping(path = "/saveVehicleID",produces = MediaType.APPLICATION_JSON_VALUE,params = {"packageID","vehicleID"})
    public ResponseEntity<Response> saveVehicleID(@RequestParam("packageID") String packageID, @RequestParam("vehicleID") String vehicleID){
        return null;
    }
    @DeleteMapping(path = "/deleteHotelID",produces = MediaType.APPLICATION_JSON_VALUE,params = {"packageID","hotelID"})
    public ResponseEntity<Response> deleteHotelID(@RequestParam("packageID") String packageID, @RequestParam("hotelID") String hotelID){
        return null;
    }

    @DeleteMapping(path = "/deleteVehicleID",produces = MediaType.APPLICATION_JSON_VALUE,params = {"packageID","vehicleID"})
    public ResponseEntity<Response> deleteVehicleID(@RequestParam("packageID") String packageID, @RequestParam("vehicleID") String vehicleID) {
        return null;
    }


    @PutMapping(path = "/updateHotelPackageId",produces = MediaType.APPLICATION_JSON_VALUE,params = {"oldPackageId","newPackageId","hotelId"})
    public ResponseEntity<Response>updateHotelPackageId(@RequestParam("oldPackageId")String oldPackageId,@RequestParam("newPackageId")String newPackageId,@RequestParam("hotelId")String hotelId) {
    return null;
    }





}
