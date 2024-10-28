package com.vid_app.springboot_backend.services;

import java.util.List;

import com.vid_app.springboot_backend.dto.UserDto;
import com.vid_app.springboot_backend.entities.User;

public interface AuthService {
    
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
    
}
