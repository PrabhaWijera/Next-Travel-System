package com.example.prabhash.vehicelserver.api;


import com.example.prabhash.vehicelserver.dto.Vehicle_dto;
import com.example.prabhash.vehicelserver.res.Response;
import com.example.prabhash.vehicelserver.service.custom.VehicleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/v1/vehicles")
public class Vehicle_api {

    @Autowired
    private VehicleService vehicleService;


    @GetMapping(path = "getVehiclesByPackageId",params = "packageId",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response>getVehicleByPackageId(@RequestParam("packageId") String packageId){
        System.out.println("getVehicleByPackageId");
        return vehicleService.findVehiclesByPackageID(packageId);
    }




    @GetMapping("/check")
    public String getCheck_vehicle(){
        return "Vehicle API run";
    }


    @PostMapping(path = "vSave",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> save(@RequestBody Vehicle_dto vehicleDto){
        System.out.println("vehicle save working"+vehicleDto.getFee_forDay());
       return vehicleService.save(vehicleDto);
    }

    @PutMapping(path = "/Vput",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> update(@RequestBody Vehicle_dto vehicleDto){
        System.out.println("VehicleDto update working in vehicle");
        System.out.println(vehicleDto.toString());
        return vehicleService.update(vehicleDto);
    }


    @DeleteMapping(path = "V_delete",params ="Vehicle_ID",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> delete(@RequestParam("Vehicle_ID") String vehicleID){
        System.out.println("controller delete");
        return vehicleService.delete(vehicleID);
    }

    @GetMapping(path = "V_search",params = "Vehicle_ID",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> search(@RequestParam("Vehicle_ID") String Vehicle_ID){
        return vehicleService.search(Vehicle_ID);
    }

//for package testing

    @GetMapping(path = "/getAllVehicle",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <Response> getAllVehicles() {
        // Return the data as a response
        System.out.println("controller vehi");
      return vehicleService.getAll();
    }



    @GetMapping(path = "/getVehicleByVehicleBrand",params = "vehicleBrand",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response>getVehicleByBrand(@RequestParam("vehicleBrand")String vehicleBrand){
        return vehicleService.findByVehicleBrand(vehicleBrand);
    }






}
