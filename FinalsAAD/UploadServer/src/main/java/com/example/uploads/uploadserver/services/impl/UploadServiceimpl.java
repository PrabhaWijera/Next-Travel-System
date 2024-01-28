package com.example.uploads.uploadserver.services.impl;


import com.example.uploads.uploadserver.services.UploadService;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;

@Service

public class UploadServiceimpl implements UploadService {


    @Override
    public String handleUploads(MultipartFile imageFile) {
        // Getting the file name.
        String fileName = imageFile.getOriginalFilename();

        // Specify the destination directory.In this case it is downloads.
        String destinationDirectory = System.getProperty("user.home") + "/Desktop";
        // Create the directory if it doesn't exist.
        File directory = new File(destinationDirectory);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Create the file path.
        String filePath = destinationDirectory + "/" + fileName;

        // Save the image file.
        try {
            imageFile.transferTo(Paths.get(filePath));
            return filePath;
        } catch (IOException e) {
            throw new RuntimeException("An error occurred while saving the image :" + e.getLocalizedMessage());
        }

    }
/*
    @Override
    public String handlePuting(MultipartFile imagefileupdateed) {
        String fileName2 = imagefileupdateed.getOriginalFilename();

        // Specify the destination directory.In this case it is downloads.
        String destinationDirectory = System.getProperty("user.home") + "/Desktop";
        // Create the directory if it doesn't exist.
        File directory = new File(destinationDirectory);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Create the file path.
        String filePath = destinationDirectory + "/" + fileName2;

        // Save the image file.
        try {
            imagefileupdateed.transferTo(Paths.get(filePath));
            return filePath;
        } catch (IOException e) {
            throw new RuntimeException("An error occurred while saving the image :" + e.getLocalizedMessage());
        }
    }*/

    @Override
    public ResponseEntity<Resource> getImage(String imagePath)  {
        File file = new File(imagePath);

        if (!file.exists()) {
            return ResponseEntity.notFound().build();
        }

        Resource resource = null;
        try {
            resource = new InputStreamResource(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .contentLength(file.length())
                .body(resource);
    }
}
