package com.vid_app.springboot_backend.services;

import java.util.List;

import com.vid_app.springboot_backend.auth.entities.User;
import com.vid_app.springboot_backend.dto.UserDto;

public interface UserService {
    
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();

}
