package com.example.packageserver.package_server.api;

import com.example.packageserver.package_server.fign.HotelInterface;
import com.example.packageserver.package_server.fign.VehicleInterface;
import com.example.packageserver.package_server.res.Response;
import com.example.packageserver.package_server.service.custom.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/pakg")
public class PackageController {

    @Autowired
    private PackageService packageService;

    @Autowired
    private HotelInterface hotelInterface;
    @Autowired
    private VehicleInterface vehicleInterface;





    @PostMapping(path = "/saveHotelID",produces = MediaType.APPLICATION_JSON_VALUE,params = {"packageID","hotelID"})
    public ResponseEntity<Response> saveHotelID(@RequestParam("packageID") String packageID, @RequestParam("hotelID") String hotelID){
        return packageService.addHotel(packageID,hotelID);
    }

    @PostMapping(path = "/saveVehicleID",produces = MediaType.APPLICATION_JSON_VALUE,params = {"packageID","vehicleID"})
    public ResponseEntity<Response> saveVehicleID(@RequestParam("packageID") String packageID, @RequestParam("vehicleID") String vehicleID){
        return packageService.addVehicle(packageID, vehicleID);
    }
    @DeleteMapping(path = "/deleteHotelID",produces = MediaType.APPLICATION_JSON_VALUE,params = {"packageID","hotelID"})
    public ResponseEntity<Response> deleteHotelID(@RequestParam("packageID") String packageID, @RequestParam("hotelID") String hotelID){
        return packageService.deleteHotel(packageID, hotelID);
    }
    @DeleteMapping(path = "/deleteVehicleID",produces = MediaType.APPLICATION_JSON_VALUE,params = {"packageID","vehicleID"})
    public ResponseEntity<Response> deleteVehicleID(@RequestParam("packageID") String packageID, @RequestParam("vehicleID") String vehicleID){
        return packageService.deleteVehicle(packageID, vehicleID);
    }
  @PutMapping(path = "/updateHotelPackageId",produces = MediaType.APPLICATION_JSON_VALUE,params = {"oldPackageId","newPackageId","hotelId"})
    public ResponseEntity<Response>updateHotelPackageId(@RequestParam("oldPackageId")String oldPackageId,@RequestParam("newPackageId")String newPackageId,@RequestParam("hotelId")String hotelId){
        return packageService.updateHotelPackageID(oldPackageId, newPackageId, hotelId);
    }
       @PutMapping(path = "/updateVehiclePackageId", produces = MediaType.APPLICATION_JSON_VALUE, params = {"oldPackageId", "newPackageId", "vehicleId"})
    public ResponseEntity<Response> updateVehiclePackageId(@RequestParam("oldPackageId") String oldPackageId, @RequestParam("newPackageId") String newPackageId, @RequestParam("vehicleId") String vehicleId) {
        return packageService.updateVehiclePackageID(oldPackageId, newPackageId, vehicleId);
    }

    @GetMapping(path = "/getPackageByCategory", produces = MediaType.APPLICATION_JSON_VALUE, params = "category")
    public ResponseEntity<Response> getPackageByCategory(@RequestParam("category") String category) {
        return packageService.getPackageByCategory(category);
    }
    @GetMapping(path = "/getPackages", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getPackages() {
        return packageService.getPackageCategoryList();
    }





}
