package com.example.prabhash.packagedetailsserver.service;

import com.example.prabhash.packagedetailsserver.dto.PackageDetails_dto;
import com.example.prabhash.packagedetailsserver.entity.PackageDetail_entity;
import com.example.prabhash.packagedetailsserver.fiegn.UserInterface;
import com.example.prabhash.packagedetailsserver.repo.PackageDetails_Repo;
import com.example.prabhash.packagedetailsserver.res.Response;
import com.fasterxml.uuid.Generators;
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
public class PackageDetails_impl implements PackageDetailsService {

    @Autowired
    private PackageDetails_Repo packageDetails_repo;

    @Autowired
    private Response response;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserInterface userInterface;



    @Override
    public ResponseEntity<Response> search(String id) {
        Optional<PackageDetail_entity> packageDetailEntity=packageDetails_repo.findById(id);
        if (packageDetailEntity.isPresent()){
            return createAndSendResponse(HttpStatus.FOUND.value(),"Success search packageDetails", modelMapper.map(packageDetailEntity.get(),PackageDetails_dto.class));
        }
        return createAndSendResponse(HttpStatus.NOT_FOUND.value(), "No found PackageDetail",null);
    }

/*    @Override
    public ResponseEntity<Response> save(PackageDetails_dto packageDetailsDto) {
        if (search(packageDetailsDto.getPackageDetailsID()).getBody().getData()==null){
            packageDetails_repo.save(modelMapper.map(packageDetailsDto,PackageDetail_entity.class));
            return createAndSendResponse(HttpStatus.OK.value(), "Success",null);
        }
        throw new RuntimeException("No save Guides");
    }*/
    @Override
    public ResponseEntity<Response> save(PackageDetails_dto packageDetailsDTO) {
    if(search(packageDetailsDTO.getPackageDetailsID()).getBody().getData() == null){
        packageDetailsDTO.setPackageDetailsID(generateId());
        packageDetails_repo.save(modelMapper.map(packageDetailsDTO, PackageDetail_entity.class));
        System.out.println("USER ID "+packageDetailsDTO.getUserID());
        System.out.println("PACKAGE DETAILS  ID "+packageDetailsDTO.getPackageDetailsID());
      //  userInterface.updatePackageDetailsID(packageDetailsDTO.getUserID(),packageDetailsDTO.getPackageDetailsID());
        return createAndSendResponse(HttpStatus.CREATED.value(), "PackageDetails Created Successfully!",null);

    }
    return createAndSendResponse(HttpStatus.CONFLICT.value(), "PackageDetails Already Exists!",null);

}
    @Override
    public ResponseEntity<Response> update(PackageDetails_dto packageDetailsDTO) {

        if(search(packageDetailsDTO.getPackageDetailsID()).getBody().getData() != null){
            packageDetails_repo.save(modelMapper.map(packageDetailsDTO, PackageDetail_entity.class));
            return createAndSendResponse(HttpStatus.OK.value(), "PackageDetails Updated Successfully!",null);

        }
        return createAndSendResponse(HttpStatus.NOT_FOUND.value(), "PackageDetails Not Found!",null);
    }


/*
    @Override
    public ResponseEntity<Response> update(PackageDetails_dto packageDetailsDto) {
        Optional<PackageDetail_entity> existingPackageDetail = packageDetails_repo.findById(packageDetailsDto.getPackageDetailsID());

        if (existingPackageDetail.isPresent()) {
            // The vehicle with the given ID exists, so update it
            PackageDetail_entity updatedEntity = modelMapper.map(packageDetailsDto, PackageDetail_entity.class);
            updatedEntity.setPackageDetailsID(packageDetailsDto.getPackageDetailsID()); // Set the ID to ensure an update
            packageDetails_repo.save(updatedEntity);
            return createAndSendResponse(HttpStatus.OK.value(), "PackageDetails updated successfully",null);
        } else {
            // The vehicle with the given ID does not exist, so create a new entry
            PackageDetail_entity newEntity = modelMapper.map(packageDetailsDto, PackageDetail_entity.class);
            packageDetails_repo.save(newEntity);
            return createAndSendResponse(HttpStatus.OK.value(), "PackageDetails created successfully",null );
        }
    }
*/

    @Override
    public ResponseEntity<Response> delete(String id) {
        if (search(id).getBody().getData() == null){
            return createAndSendResponse(HttpStatus.NOT_FOUND.value(),"NOT Found Packages ",null);
        }
        packageDetails_repo.deleteById(id);
        return createAndSendResponse(HttpStatus.OK.value(), "Package Delete SuccessFully",null);
    }

    @Override
    public ResponseEntity<Response> getAll() {
        List<PackageDetail_entity>packageDetailEntities=packageDetails_repo.findAll();
        if (!packageDetailEntities.isEmpty()){
             List<PackageDetails_dto>packageDetailsDtos=new ArrayList<>();
            packageDetailEntities.forEach(packageDetailEntity -> {
                packageDetailsDtos.add(modelMapper.map(packageDetailEntity,PackageDetails_dto.class));
            });
            return createAndSendResponse(HttpStatus.OK.value(), "Success get All package details",null);
        }
        return createAndSendResponse(HttpStatus.NOT_FOUND.value(),"No success",null);
    }

    @Override
    public ResponseEntity<Response> createAndSendResponse(int statusCode, String msg, Object data) {
        response.setStatusCode(statusCode);
        response.setMessage(msg);
        response.setData(data);
        System.out.println("Status Code : " + statusCode);
        System.out.println("Sent : " + HttpStatus.valueOf(statusCode));

        return new ResponseEntity<Response>(response, HttpStatusCode.valueOf(statusCode));

    }

    public List<Integer>getAllID(){
        List<Integer> allIDs= packageDetails_repo.getAllID();
        System.out.println(allIDs);
        return allIDs;
    }


    @Override
    public ResponseEntity<Response> getPackageDetailsByUser(String userId) {
        List<PackageDetail_entity> packs = packageDetails_repo.findByuserID(userId);
        if(packs.isEmpty()){
            return createAndSendResponse(HttpStatus.NOT_FOUND.value(), "PackageDetails Not Found!",null);

        }
        List<PackageDetails_dto>packageDetailsDTOList = new ArrayList<>();
        packs.forEach((p)->{
            packageDetailsDTOList.add(modelMapper.map(p,PackageDetails_dto.class));

        });

        return createAndSendResponse(HttpStatus.FOUND.value(), "PackageDetails Retrieved Successfully!",packageDetailsDTOList);

    }

    @Override
    public ResponseEntity<Response> deletePackageDetailsByUser(String userId) {
        List<PackageDetail_entity> packs = packageDetails_repo.findByuserID(userId);
        if(packs.isEmpty()){
            return createAndSendResponse(HttpStatus.NOT_FOUND.value(), "No PackageDetails found to delete!",null);

        }
        packs.forEach((p)->{
            packageDetails_repo.deleteById(p.getPackageDetailsID());

        });
        return createAndSendResponse(HttpStatus.OK.value(), "PackageDetails Deleted Successfully!",null);

    }

    @Override
    public String generateId() {
        return  "NEXT" +  Generators.randomBasedGenerator().generate().toString();
    }





}
