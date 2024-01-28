package com.example.user_server.user.endpointother;

import com.example.user_server.user.dto.Guide_dto;
import com.example.user_server.user.fiegn.GuideAuthfiegnInterface;
import com.example.user_server.user.res.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("")
public class Guide_api {

    @Autowired
    private GuideAuthfiegnInterface  guideAuthfiegnInterface;



   @PostMapping(path = "Gsave",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response save(@RequestBody Guide_dto guideDto){
       System.out.println("Guide save"+guideDto.toString());
       return guideAuthfiegnInterface.saveGuide(guideDto);

   }

   @GetMapping(path = "Gget",params = "guideID",produces = MediaType.APPLICATION_JSON_VALUE)
    public Response get(@RequestParam("guideID") String guideID){
       System.out.println("Guide search"+guideID);
     return guideAuthfiegnInterface.get(guideID);
   }

   @PutMapping(path = "Gput",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
   public Response update(  @RequestBody Guide_dto guideDto){
       System.out.println("update guide"+guideDto.toString());
       return guideAuthfiegnInterface.saveGuide(guideDto);
   }

   @DeleteMapping(path = "Gdelete",params = "guideID",produces = MediaType.APPLICATION_JSON_VALUE)
   public Response delete(   @RequestParam("guideID") String guideID){
       System.out.println("Guide delete ok"+guideID);
       return guideAuthfiegnInterface.delete(guideID);
   }






}
