package com.example.prabhash.vehicelserver.service;

import com.example.prabhash.vehicelserver.dto.Vehicle_dto;
import com.example.prabhash.vehicelserver.entity.Vehicle_entity;
import com.example.prabhash.vehicelserver.fiegn.PackageInterface;
import com.example.prabhash.vehicelserver.repo.Vehicle_repo;
import com.example.prabhash.vehicelserver.res.Response;
import com.example.prabhash.vehicelserver.service.custom.VehicleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class VehicleService_impl implements VehicleService {

    @Autowired
    private Vehicle_repo vehicleRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private Response response;

    @Autowired
    private PackageInterface packageInterface;

    @Override
    public ResponseEntity<Response> search(String id) {
        Optional<Vehicle_entity> vehicleEntity=vehicleRepo.findById(id);
        if (vehicleEntity.isPresent()){
            return createAndSendResponse(HttpStatus.OK.value(), "sucsss",modelMapper.map(vehicleEntity.get(),Vehicle_dto.class));
        }
        return createAndSendResponse(HttpStatus.NOT_FOUND.value(), "error found vehicle",null);
    }

    @Override
    public ResponseEntity<Response> save(Vehicle_dto vehicleDto) {
        if (search(vehicleDto.getVehicleID()).getBody().getData()==null){
               vehicleRepo.save(modelMapper.map(vehicleDto,Vehicle_entity.class));
            System.out.println(vehicleDto.getFee_forDay());
               Vehicle_dto dto= (Vehicle_dto) findByVehicleName(vehicleDto.getVehicleName()).getBody().getData();
               packageInterface.saveVehicleID(vehicleDto.getPackageId(),dto.getVehicleID());
            return createAndSendResponse(HttpStatus.CREATED.value(),"save ok vehicle",true);
        }
        return createAndSendResponse(HttpStatus.CONFLICT.value(), "Hotel Already Exists!", false);
    }




    @Override
    public ResponseEntity<Response> update(Vehicle_dto vehicleDto) {
        Optional<Vehicle_entity> existingVehicle = vehicleRepo.findById(vehicleDto.getVehicleID());

        if (existingVehicle.isPresent()) {
            // The vehicle with the given ID exists, so update it
            Vehicle_entity updatedEntity = modelMapper.map(vehicleDto, Vehicle_entity.class);
            updatedEntity.setVehicleID(vehicleDto.getVehicleID()); // Set the ID to ensure an update
            vehicleRepo.save(updatedEntity);
            return createAndSendResponse(HttpStatus.OK.value(), "Vehicle updated successfully",null);
        } else {
            // The vehicle with the given ID does not exist, so create a new entry
            Vehicle_entity newEntity = modelMapper.map(vehicleDto, Vehicle_entity.class);
            vehicleRepo.save(newEntity);
            return createAndSendResponse(HttpStatus.OK.value(), "Vehicle created successfully",null );
        }
    }


    @Override
    public ResponseEntity<Response> delete(String id) {
        if(search(id).getBody().getData() == null){
            return createAndSendResponse(HttpStatus.NOT_FOUND.value(),"Not Found Vehicle",null);
        }
        vehicleRepo.deleteById(id);
        System.out.println("service delete");
        return createAndSendResponse(HttpStatus.OK.value(), "Vehicle Suceesfully Dlete",null);
    }

    @Override
    public ResponseEntity<Response> getAll() {
        List<Vehicle_entity> vehicles =vehicleRepo.findAll();
        if (!vehicles.isEmpty()){
            List<Vehicle_dto>vehicleDTOS =new ArrayList<>();
            vehicles.forEach(vehicleEntity -> {
                vehicleDTOS.add(modelMapper.map(vehicleEntity,Vehicle_dto.class));
                System.out.println("service vehi");
            });
            return createAndSendResponse(HttpStatus.OK.value(), "Hotels Successfully retrieved!", vehicleDTOS);
        }
        return createAndSendResponse(HttpStatus.NOT_FOUND.value(),"No success Found ",null);
    }

    @Override
    public ResponseEntity<Response> createAndSendResponse(int statusCode, String msg, Object data) {
        response.setStatusCode(statusCode);
        response.setMessage(msg);
        response.setData(data);
        System.out.println("Status Code : " + statusCode);
        System.out.println("Sent : " + HttpStatus.valueOf(statusCode));

        return new ResponseEntity<>(response, HttpStatusCode.valueOf(statusCode));

    }

    @Override
    public ResponseEntity<Response> deleteAllVehicle(List<String> vehicleIDList) {
        return null;
    }

    @Override
    public ResponseEntity<Response> findByVehicleName(String vehicleName) {
        Optional<Vehicle_entity> vehi = vehicleRepo.findByVehicleName(vehicleName);
        if (vehi.isPresent()) {
            return createAndSendResponse(HttpStatus.OK.value(), "vehicleName Successfully retrieved!", modelMapper.map( vehi.get(), Vehicle_dto.class));

        }
        return createAndSendResponse(HttpStatus.NOT_FOUND.value(), "Hotel Not Found!", null);
    }



    @Override
    public ResponseEntity<Response> findByVehicleBrand(String vehicleBrand) {
        Optional<Vehicle_entity> vehicle = vehicleRepo.findByVehicleBrand(vehicleBrand);
        if (vehicle.isPresent()) {
            return createAndSendResponse(HttpStatus.OK.value(), "Vehicle Successfully retrieved!", modelMapper.map(vehicle.get(), Vehicle_dto.class));

        }
        return createAndSendResponse(HttpStatus.NOT_FOUND.value(), "Vehicle Not Found!", null);
    }

    @Override
    public ResponseEntity<Response> findVehiclesByPackageID(String packageId) {
        List<Vehicle_entity> vehicle=vehicleRepo.findByPackageId(packageId);
        if (vehicle.isEmpty()){
            return createAndSendResponse(HttpStatus.NOT_FOUND.value(), "Vehicles not found the given Package!!!",null);

        }
        List<Vehicle_dto>vehicleDtos=new ArrayList<>();
        vehicle.forEach(vE -> {
            vehicleDtos.add(modelMapper.map(vE,Vehicle_dto.class));
        });
        System.out.println("findVehiclesByPackageID");
        return createAndSendResponse(HttpStatus.OK.value(),"Vehicle Success received",vehicleDtos);
    }
}
