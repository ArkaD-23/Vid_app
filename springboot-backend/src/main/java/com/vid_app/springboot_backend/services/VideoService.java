package com.vid_app.springboot_backend.services;

import java.util.List;

import com.vid_app.springboot_backend.entities.Video;

public interface VideoService {

    Video save(Video video, Video file);

    Video get(String videoId);

    Video getByTitle(String title);

    List<Video> getAll();
    
}
