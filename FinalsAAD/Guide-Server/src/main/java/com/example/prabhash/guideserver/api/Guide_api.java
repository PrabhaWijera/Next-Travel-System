package com.example.prabhash.guideserver.api;


import com.example.prabhash.guideserver.dto.Guide_dto;
import com.example.prabhash.guideserver.entity.Guide_entity;
import com.example.prabhash.guideserver.fiegn.Packageinterface;
import com.example.prabhash.guideserver.res.Response;
import com.example.prabhash.guideserver.service.custom.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("api/v1/guide")
public class Guide_api {


    @Autowired
    private GuideService guideService;

    @Autowired
    private Packageinterface packageinterface;

   @PostMapping(path = "/Gsave",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <Response>  saveGuide( @RequestBody Guide_dto guideDto){
       System.out.println("Guide save controller"+guideDto.toString());
       return guideService.save(guideDto);

   }



    @GetMapping(path = "Gget",params = "guideID",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <Response> get(@RequestParam("guideID") String guideID){
       System.out.println("Guide search"+guideID);
     return guideService.search(guideID);
   }

   @PutMapping(path = "Gput",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<Response> update( @RequestBody Guide_dto guideDto){
       System.out.println("update guide"+guideDto.toString());
       return guideService.update(guideDto);
   }

   @DeleteMapping(path = "Gdelete",params = "guideID",produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<Response>  delete(@RequestParam("guideID") String guideID){
     ResponseEntity<Response> response= get(guideID);
     Guide_dto guideDto= (Guide_dto) response.getBody().getData();
       guideService.delete(guideID);
       return packageinterface.deleteGuideID(guideDto.getPackageId(),guideDto.getGuideID());
   }

    @GetMapping(path = "/getGuideByGuideName",params = "guideName",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response>getGuideByName(@RequestParam("guideName")String guideName){
        return guideService.findByGuideName(guideName);
    }
    @GetMapping(path = "/getAllGuide",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <Response> getAllGuides() {
        // Return the data as a response
        return guideService.getAll();
    }

    @DeleteMapping(path = "/deleteAllGuides",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response>deleteAllGuides(@RequestBody List<String> guideID){
       return guideService.deleteAllGuides(guideID);
    }






}
