package com.example.user_server.user.endpointother;

import com.example.user_server.user.fiegn.ImageUploader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin
@RestController
@RequestMapping("api/v1/uploadingUploader")
public class UploadController {

    @Autowired
    private ImageUploader imageUploader;

    @PostMapping(path = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String handleUploads(@RequestParam("imageFile") MultipartFile imageFile) {

        return imageUploader.handleUploads(imageFile);


    }

    @GetMapping(path = "/getImage",params = "imagePath")
    public ResponseEntity<Resource> getImage(@RequestParam("imagePath") String imagePath) {

        return imageUploader.getImage(imagePath);
    }
}
