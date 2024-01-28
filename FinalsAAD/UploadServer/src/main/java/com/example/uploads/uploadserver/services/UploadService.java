package com.example.uploads.uploadserver.services;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
    String handleUploads(MultipartFile multipartFile);

/*    String handlePuting(MultipartFile multipartFile);*/

    ResponseEntity<Resource> getImage(String imagePath);
}
