package com.example.prabhash.vehicelserver.service.custom;

import com.example.prabhash.vehicelserver.dto.Vehicle_dto;
import com.example.prabhash.vehicelserver.res.Response;
import com.example.prabhash.vehicelserver.service.SuperService;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface VehicleService  extends SuperService<Vehicle_dto,String> {
    ResponseEntity<Response> deleteAllVehicle(List<String> vehicleIDList);
    ResponseEntity<Response> findByVehicleName(String vehicleName);


    ResponseEntity<Response> findByVehicleBrand(String vehicleBrand);

    ResponseEntity<Response> findVehiclesByPackageID(String packageId);
}
