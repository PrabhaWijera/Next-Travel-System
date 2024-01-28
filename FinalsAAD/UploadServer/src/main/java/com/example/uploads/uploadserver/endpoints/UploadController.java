package com.example.uploads.uploadserver.endpoints;

import com.example.uploads.uploadserver.services.UploadService;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

@CrossOrigin
@RestController
@RequestMapping("api/v1/uploadingUploader")
public class UploadController {

    @Autowired
    private UploadService uploadService;

    @PostMapping(path = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String handleUploads(@RequestParam("imageFile") MultipartFile imageFile) {

        System.out.println("Downloaded!!!!");
        return uploadService.handleUploads(imageFile);


    }

/*    @PutMapping(path = "/putMethod", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String handlePuting(@RequestParam("imageFile") MultipartFile imageFile) {

        System.out.println("Download updated!!!!");
        return uploadService.handleUploads(imageFile);


    }*/

    @GetMapping(path = "/getImage",params = "imagePath")
    public ResponseEntity<Resource> getImage(@RequestParam("imagePath") String imagePath) {
        System.out.println("Uploaded!!!!");
        return uploadService.getImage(imagePath);
    }

}
