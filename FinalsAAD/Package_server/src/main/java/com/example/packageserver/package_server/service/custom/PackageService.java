package com.example.packageserver.package_server.service.custom;

import com.example.packageserver.package_server.dto.Package_dto;
import com.example.packageserver.package_server.res.Response;
import com.example.packageserver.package_server.service.SuperService;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PackageService extends SuperService<Package_dto,String> {
    List<Integer> getAllID();
    public ResponseEntity<Response> addHotel(String packageID, String hotelID) ;

    public ResponseEntity<Response> deleteHotel(String packageID, String hotelID);
    public ResponseEntity<Response> addVehicle(String packageID, String vehicleID);
    public ResponseEntity<Response> deleteVehicle(String packageID, String vehicleID);
    public List<String> getVehiclesList(String packageID);
    public ResponseEntity<Response> updateHotelPackageID(String oldPackageId, String newPackageId, String hotelId);
    public ResponseEntity<Response> updateVehiclePackageID(String oldPackageId, String newPackageId, String vehicleId);
    public List<String> getHotelsList(String packageID);

    ResponseEntity<Response> getPackageByCategory(String category);

    List<String> getPackageCategoryList();
}
