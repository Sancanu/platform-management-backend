package com.management.platform.controller;


import com.management.platform.dto.AuthenticationRequest;
import com.management.platform.dto.AuthenticationResponse;
import com.management.platform.dto.RegisteredRequest;
import com.management.platform.entity.User;
import com.management.platform.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(path = "user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping
    public User createOrUpdateProject(@RequestBody User user){

        userService.saveOrUpdate(user);
        return user;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisteredRequest request){
        return  ResponseEntity.ok((userService.register(request) ));
    }

    @PostMapping("/authentication")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request){
        return  ResponseEntity.ok((userService.authenticate(request) ));
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<AuthenticationResponse> refreshToken(
            HttpServletRequest request
    )  {
        return ResponseEntity.ok((userService.refreshToken(request)));
    }


}
