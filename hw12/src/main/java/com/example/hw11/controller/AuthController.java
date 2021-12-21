package com.example.hw11.controller;

import com.example.hw11.model.User;
import com.example.hw11.security.JwtTokenProvider;
import com.example.hw11.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthController {
    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthController(UserService userService, JwtTokenProvider jwtTokenProvider) {
        this.userService = userService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody AuthRequest authRequest) {
        User u = new User();
        u.setPassword(authRequest.getPassword());
        u.setUsername(authRequest.getUsername());
        u.setFirstname(authRequest.getFirstname());
        u.setLastname(authRequest.getLastname());
        userService.saveUser(u);
        return "OK";
    }

    @PostMapping("/auth")
    public AuthResponse auth(@RequestBody AuthRequest request) {
        User user = userService.findByUsernameAndPassword(request.getUsername(), request.getPassword());
        String token = jwtTokenProvider.createToken(user.getUsername());
        return new AuthResponse(token);
    }
}