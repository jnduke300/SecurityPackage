package com.dvi.app.security.securitypackage.api;

import com.dvi.app.security.securitypackage.models.User;
import com.dvi.app.security.securitypackage.service.UserServiceImpl;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RequestMapping("/api")
@RestController
public class UserController {

    private UserServiceImpl userService;

    @GetMapping("/users")
    ResponseEntity<List<User>> getAllUsers(){
        List<User> allUsers = userService.findAllUsers();
        return ResponseEntity.ok().body(allUsers);
    }
    @GetMapping("/user")
    ResponseEntity<User> getSpecificUser(@RequestBody String username){
        User userByUsername = userService.findUserByUsername(username);
        return ResponseEntity.status(HttpStatus.FOUND).body(userByUsername);
    }



}
