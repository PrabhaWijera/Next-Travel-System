package com.example.user_server.user.endpointother;


import com.example.user_server.user.dto.Package_dto;
import com.example.user_server.user.fiegn.PackageAuthfiegnInterface;
import com.example.user_server.user.res.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/package_server")
public class Package {
    Package(){
        System.out.println("Package_api_working_on!!!");
    }

    @Autowired
    private PackageAuthfiegnInterface packageAuthfiegnInterface;



    @GetMapping("/check")
    public String getCheck_package(){
        return "Package API Running";
    }

    @PostMapping(path = "/P_save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response save(@RequestBody Package_dto packageDto){
        System.out.println("Package save working");
        return packageAuthfiegnInterface.save(packageDto);
    }

    @PutMapping(path = "/P_put",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response update(@RequestBody Package_dto packageDto){
        System.out.println("Package update working");
        return packageAuthfiegnInterface.update(packageDto);
    }

    @DeleteMapping(path = "/P_dlt",params = "P_id",produces = MediaType.APPLICATION_JSON_VALUE)
    public Response delete(@RequestParam("P_id") String packageId){
        return packageAuthfiegnInterface.delete(packageId);
    }

    @GetMapping(path = "/P_search",params = "Package_ID",produces = MediaType.APPLICATION_JSON_VALUE)
    public Response  search(@RequestParam("Package_ID") String packageID){
        return packageAuthfiegnInterface.search(packageID);
    }



}
