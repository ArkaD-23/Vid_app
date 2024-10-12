package com.vid_app.springboot_backend.controllers;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.vid_app.springboot_backend.entities.Video;
import com.vid_app.springboot_backend.payload.CustomMessage;
import com.vid_app.springboot_backend.services.VideoService;

@RestController
@RequestMapping("/api/v1")
public class VideoController {

    private VideoService videoService;

    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @PostMapping("/videos")
    public ResponseEntity<CustomMessage> create(
        @RequestParam("file") MultipartFile file,
        @RequestParam("title") String title,
        @RequestParam("description") String description
    ){

            Video video = new Video();
            video.setTitle(title);
            video.setDescription(description);
            video.setVideoId(UUID.randomUUID().toString());

            videoService.save(video, file);

            CustomMessage message = new CustomMessage("Video uploaded successfully", true);
            return ResponseEntity.ok(message);
    }
}
