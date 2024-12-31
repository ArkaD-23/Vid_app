package com.vid_app.springboot_backend.auth.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vid_app.springboot_backend.auth.entities.User;
import com.vid_app.springboot_backend.auth.entities.UserRole;
import com.vid_app.springboot_backend.auth.repositories.UserRepository;
import com.vid_app.springboot_backend.auth.utils.AuthResponse;
import com.vid_app.springboot_backend.auth.utils.RegisterRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final RefreshTokenService refreshTokenService;
    private final AuthenticationManager authenticationManager;

}
