package com.vid_app.springboot_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vid_app.springboot_backend.entities.User;

public interface UserRepository extends JpaRepository<User, String>{
    User findByEmail(String email);
}
