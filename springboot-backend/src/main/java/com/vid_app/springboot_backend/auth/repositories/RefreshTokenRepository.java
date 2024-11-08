package com.vid_app.springboot_backend.auth.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vid_app.springboot_backend.auth.entities.RefreshToken;

public interface RefreshTokenRepository extends JpaRepository<RefreshTokenRepository, Integer> {

    Optional<RefreshToken> findByRefreshToken(String refreshToken);
}
