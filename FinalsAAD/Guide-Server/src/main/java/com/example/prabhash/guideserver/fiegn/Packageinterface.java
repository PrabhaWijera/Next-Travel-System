package com.example.prabhash.guideserver.fiegn;

import com.example.prabhash.guideserver.res.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient("package-server")
public interface Packageinterface {

    @DeleteMapping(path = "/deleteGuideID",produces = MediaType.APPLICATION_JSON_VALUE,params = {"packageID","guideID"})
    public ResponseEntity<Response> deleteGuideID(@RequestParam("packageID") String packageID, @RequestParam("guideID") String guideID);

}
