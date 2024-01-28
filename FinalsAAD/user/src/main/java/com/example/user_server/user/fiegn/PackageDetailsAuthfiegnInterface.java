package com.example.user_server.user.fiegn;

import com.example.user_server.user.dto.PackageDetails_dto;
import com.example.user_server.user.res.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@FeignClient("PACKAGE-DETAILS-SERVICE")
public interface PackageDetailsAuthfiegnInterface {



    @PostMapping(path = "save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response save(@RequestBody PackageDetails_dto packageDetailsDto);

    @PutMapping(path = "put",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response update(@RequestBody PackageDetails_dto packageDetailsDto);


    @DeleteMapping(path = "delete",params = "PkID",produces = MediaType.APPLICATION_JSON_VALUE)
    public Response delete(@RequestParam("PkID") String PkID);

    @GetMapping(path = "get",params = "PkID",produces = MediaType.APPLICATION_JSON_VALUE)
    public Response search(@RequestParam("PkID")String PkID);

}
