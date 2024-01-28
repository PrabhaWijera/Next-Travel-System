package com.example.prabhash.vehicelserver.fiegn;

import com.example.prabhash.vehicelserver.res.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("package-server")
public interface PackageInterface {

//    @DeleteMapping(path = "/deleteVehicleID",produces = MediaType.APPLICATION_JSON_VALUE,params = {"packageID","vehicleID"})
//    public ResponseEntity<Response> deleteVehicleID(@RequestParam("packageID") String packageID, @RequestParam("vehicleID") String vehicleID);

    @PutMapping(path = "/updateHotelPackageId",produces = MediaType.APPLICATION_JSON_VALUE,params = {"oldPackageId","newPackageId","hotelId"})
    public ResponseEntity<Response> updateVehiclePackageId(@RequestParam ("packageId") String packageId, @RequestParam ("packageId1") String packageId1,@RequestParam("vehicleID") String vehicleID);

    @PostMapping(path = "api/v1/pakg/saveVehicleID",produces = MediaType.APPLICATION_JSON_VALUE,params = {"packageID","vehicleID"})
    public ResponseEntity<Response> saveVehicleID(@RequestParam("packageID") String packageID, @RequestParam("vehicleID") String vehicleID);

}
