package com.vid_app.springboot_backend.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.vid_app.springboot_backend.entities.Video;

public interface VideoService {

    Video save(Video video, MultipartFile file);

    Video get(String videoId);

    Video getByTitle(String title);

    List<Video> getAll();
    
}
