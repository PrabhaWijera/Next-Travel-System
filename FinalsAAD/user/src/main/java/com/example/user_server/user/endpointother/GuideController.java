package com.example.user_server.user.endpointother;

import com.example.user_server.user.dto.Guide_dto;
import com.example.user_server.user.fiegn.GuideAuthfiegnInterface;
import com.example.user_server.user.res.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/v1/guide")
public class GuideController {

    @Autowired
    private GuideAuthfiegnInterface guideAuthfiegnInterface;

    @PostMapping(path = "/saveGuide",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response saveGuide(@RequestBody Guide_dto guideDto){
        return guideAuthfiegnInterface.saveGuide(guideDto);
    }


    @GetMapping(path = "Gget",params = "guideID",produces = MediaType.APPLICATION_JSON_VALUE)
    public Response get( @RequestParam("guideID") String guideID){
        System.out.println("Guide search"+guideID);
        return guideAuthfiegnInterface.get(guideID);
    }

    @PutMapping(path = "Gput",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response update( @RequestBody Guide_dto guideDto){
        System.out.println("update guide"+guideDto.toString());
        return guideAuthfiegnInterface.update(guideDto);
    }

    @DeleteMapping(path = "Gdelete",params = "guideID",produces = MediaType.APPLICATION_JSON_VALUE)
    public Response delete(  @RequestParam("guideID") String guideID){
        System.out.println("Guide delete ok"+guideID);
        return guideAuthfiegnInterface.delete(guideID);
    }




}
