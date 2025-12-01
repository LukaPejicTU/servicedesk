package com.example.servicedesk.controller;

import com.example.servicedesk.dto.RegisterRequest;
import com.example.servicedesk.entity.UserEntity;
import com.example.servicedesk.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    UserEntity registerUser(@RequestBody RegisterRequest request) {
        return userService.registerUser(request.username(), request.password(), request.role());
    }
}
