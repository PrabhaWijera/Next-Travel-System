package com.example.user_server.user.api;


import com.example.user_server.user.dto.User_dto;
import com.example.user_server.user.res.Response;
import com.example.user_server.user.service.custom.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/v1/userApi")
public class User_api {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/getUserByUserName", produces = MediaType.APPLICATION_JSON_VALUE, params = {"username", "password"})
    public ResponseEntity<Response> getUserByUserName(@RequestParam("username") String username, @RequestParam("password") String password) {
        System.out.println("-------------------------------------------");
        return userService.getUserByUserName(username, password);

    }

    @PostMapping(path = "/saveUser", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> saveUser(@RequestBody User_dto userDTO) {
        return userService.add(userDTO);
    }
    @PutMapping(path = "/updateUser", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> updateUser(@RequestBody User_dto userDTO) {
        return userService.update(userDTO);
    }
    @DeleteMapping(path = "/deleteUser", produces = MediaType.APPLICATION_JSON_VALUE, params = {"userId"})
    public ResponseEntity<Response> deleteUser(@RequestParam("userId") String userId) {
        return userService.delete(userId);
    }

    @GetMapping(path = "/getAllUsers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> saveUser() {
        return userService.getAll();
    }


    @GetMapping(path = "U_searching",params = "userId",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <Response> get(@RequestParam("userId") String userId){
        System.out.println("user search"+userId);
        return userService.search(userId);
    }


}
