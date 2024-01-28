package com.example.user_server.user.service.custom;



import com.example.user_server.user.dto.User_dto;
import com.example.user_server.user.res.Response;
import com.example.user_server.user.service.SuperService;
import org.springframework.http.ResponseEntity;

import org.springframework.web.multipart.MultipartFile;

public interface UserService extends SuperService<User_dto,String> {
    ResponseEntity<Response> createAndSendResponse(int statusCode, String message, Object data);
    String  handleUploads(MultipartFile imageFile);
    ResponseEntity<Response>getUserByUserName(String username,String password);
    Boolean passwordValidator(String password,String hashedPassword);

}
