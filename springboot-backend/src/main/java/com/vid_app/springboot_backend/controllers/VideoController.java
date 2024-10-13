package com.vid_app.springboot_backend.controllers;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
    public ResponseEntity<?> create(
        @RequestParam("file") MultipartFile file,
        @RequestParam("title") String title,
        @RequestParam("description") String description
    ){

            Video video = new Video();
            video.setTitle(title);
            video.setDescription(description);
            video.setVideoId(UUID.randomUUID().toString());

            Video savedVideo = videoService.save(video, file);
            if(savedVideo != null) {
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(video);
            } else {
                return ResponseEntity
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(CustomMessage.builder()
                                .message("Video not uploaded.....")
                                .success(false)
                                .build()
                        );
            }
    }
}
