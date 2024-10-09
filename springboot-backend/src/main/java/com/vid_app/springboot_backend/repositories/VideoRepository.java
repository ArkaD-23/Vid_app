package com.vid_app.springboot_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vid_app.springboot_backend.entities.Video;

import java.util.Optional;

@Repository
public interface VideoRepository extends JpaRepository<Video, String>{
    Optional<Video> findByTitle(String title);
}
