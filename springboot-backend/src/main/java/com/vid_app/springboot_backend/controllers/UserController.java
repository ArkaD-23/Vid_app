package com.vid_app.springboot_backend.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vid_app.springboot_backend.services.UserService;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
}
