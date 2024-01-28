package com.example.packageserver.package_server.api;

import com.example.packageserver.package_server.dto.Package_dto;
import com.example.packageserver.package_server.res.Response;
import com.example.packageserver.package_server.service.custom.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/v1/package_server")
public class Package {
    Package(){
        System.out.println("Package_api_working_on!!!");
    }

    @Autowired
    private PackageService packageService;



    @GetMapping("/check")
    public String getCheck_package(){
        return "Package API Running";
    }

    @PostMapping(path = "P_save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> save(@RequestBody Package_dto packageDto){
        System.out.println("Package save working");
        return packageService.save(packageDto);
    }
    @GetMapping(path = "/P_getAll",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <Response> getAllPackages() {
        // Return the data as a response
        return packageService.getAll();
    }

    @PutMapping(path = "P_put",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> update(@RequestBody Package_dto packageDto){
        System.out.println("Package update working");
        return packageService.update(packageDto);
    }

    @DeleteMapping(path = "P_dlt",params = "P_id",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> delete(@RequestParam("P_id") String packageId){
        return packageService.delete(packageId);
    }

    @GetMapping(path = "P_search",params = "Package_ID",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response>  search(@RequestParam("Package_ID") String packageID){
        return packageService.search(packageID);
    }



}
