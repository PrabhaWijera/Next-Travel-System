package com.example.user_server.user.api;

import com.example.user_server.user.dto.User_dto;
import com.example.user_server.user.res.Response;
import com.example.user_server.user.service.custom.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1/auth")
@CrossOrigin
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping(path = "/getAuth", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> getAuth(@RequestBody  User_dto userDTO) {
        System.out.println(userDTO.toString());
        return userService.add(userDTO);
    }

    @PostMapping(path = "/uploadImage",params = "userId")
    public ResponseEntity<Response> uploadImage(@RequestParam("imageFile") MultipartFile imageFile, @RequestParam("userId") String userId) {
        ResponseEntity<Response> user = userService.search(userId);

        User_dto userData = (User_dto) user.getBody().getData();
        if(userData!=null){
            userData.setUserImageLocation(userService.handleUploads(imageFile));
            return userService.update(userData);
        }
        throw new RuntimeException("User not found!");

    }

    @GetMapping(path = "/hello")
    public String  getRole(){
        return "Hello nigger!";

    }

}
