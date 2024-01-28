package com.example.user_server.user.endpointother;



import com.example.user_server.user.dto.PackageDetails_dto;
import com.example.user_server.user.fiegn.PackageDetailsAuthfiegnInterface;
import com.example.user_server.user.res.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("packageDetals")
@RestController
public class PackageDetails_api {

    @Autowired
    private PackageDetailsAuthfiegnInterface packageDetailsAuthfiegnInterface;


    @GetMapping("check")
    public String getCheck(){
        return "Checked OK packageDetails";
    }

    @PostMapping(path = "save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response save(@RequestBody PackageDetails_dto packageDetailsDto){
        return packageDetailsAuthfiegnInterface.save(packageDetailsDto);
    }

    @PutMapping(path = "put",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response update(@RequestBody PackageDetails_dto packageDetailsDto){
        return packageDetailsAuthfiegnInterface.update(packageDetailsDto);
    }


    @DeleteMapping(path = "delete",params = "PkID",produces = MediaType.APPLICATION_JSON_VALUE)
    public Response delete(@RequestParam("PkID") String PkID){
        return packageDetailsAuthfiegnInterface.delete(PkID);
    }

    @GetMapping(path = "get",params = "PkID",produces = MediaType.APPLICATION_JSON_VALUE)
    public Response search(@RequestParam("PkID")String PkID){
        return packageDetailsAuthfiegnInterface.search(PkID);
    }

}
