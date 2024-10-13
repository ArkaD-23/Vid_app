package com.vid_app.springboot_backend.services.impl;

import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;

import com.vid_app.springboot_backend.entities.Video;
import com.vid_app.springboot_backend.repositories.VideoRepository;
import com.vid_app.springboot_backend.services.VideoService;

import jakarta.annotation.PostConstruct;

@Service
public class VideoServiceImpl implements VideoService {
    
    @Value("${files.video}")
    String DIR;

    @Autowired
    private VideoRepository videoRepository;

    public VideoServiceImpl(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @PostConstruct
    public void init() {

        System.out.println("Video directory: " + DIR);
        File file = new File(DIR);

        if(!file.exists()) {
            file.mkdir();
            System.out.println("Folder created successfully.....");
        } else {
            System.out.println("Folder already exists.....");
        } 
    }

    @Override
    public Video save(Video video, MultipartFile file) {
        

        try {    
            String filename = file.getOriginalFilename();
            String contentType = file.getContentType();
            InputStream inputstream = file.getInputStream();

            //file path
            String cleanFileName = StringUtils.cleanPath(filename);
            
            //folder path
            String cleanDIR = StringUtils.cleanPath(DIR);

            //folder path with filename
            Path path = Paths.get(cleanDIR, cleanFileName);
            System.out.println(path);
            System.out.println(contentType);

            //copy file to the folder
            Files.copy(inputstream, path, StandardCopyOption.REPLACE_EXISTING);

            //video meta data
            video.setContentType(contentType);
            video.setFilePath(path.toString());

            //meta data save
            videoRepository.save(video);

            return video;
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Video get(String videoId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public Video getByTitle(String title) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByTitle'");
    }

    @Override
    public List<Video> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

}
