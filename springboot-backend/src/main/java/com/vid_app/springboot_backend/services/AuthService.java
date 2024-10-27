package com.vid_app.springboot_backend.services;

import com.vid_app.springboot_backend.entities.User;

public interface AuthService {
    
    User signup(String username, String password, String email);

    User signin(String email, String password);

    User signout(String userId);
}
