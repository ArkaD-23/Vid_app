package com.vid_app.springboot_backend.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vid_app.springboot_backend.services.AuthService;

@RestController
@RequestMapping("/api/v1")
public class AuthController {
    
    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }
}
