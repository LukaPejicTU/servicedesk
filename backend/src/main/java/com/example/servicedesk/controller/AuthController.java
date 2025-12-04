package com.example.servicedesk.controller;

import com.example.servicedesk.dto.LoginRequest;
import com.example.servicedesk.dto.LoginResponse;
import com.example.servicedesk.dto.RegisterRequest;
import com.example.servicedesk.entity.UserEntity;
import com.example.servicedesk.security.JwtUtil;
import com.example.servicedesk.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public AuthController(UserService userService, AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public UserEntity registerUser(@RequestBody RegisterRequest request) {
        return userService.registerUser(request.username(), request.password(), request.role());
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.username(), request.password())
        );

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        String jwt = jwtUtil.generateToken(userDetails);

        return new LoginResponse(jwt);
    }


}
