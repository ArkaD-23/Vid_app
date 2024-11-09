package com.vid_app.springboot_backend.auth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.vid_app.springboot_backend.auth.repositories.UserRepository;

@Configuration
public class ApplicationConfig {
    
    private final UserRepository userRepository;

    public ApplicationConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // public UserDetailService userDetailService() {
    //     return username -> userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("The username is not found : "+ username));
    // }
}
