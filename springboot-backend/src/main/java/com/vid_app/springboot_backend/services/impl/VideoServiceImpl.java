package com.vid_app.springboot_backend.services.impl;

import java.util.*;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;

import com.vid_app.springboot_backend.entities.Video;
import com.vid_app.springboot_backend.services.VideoService;

import jakarta.annotation.PostConstruct;

@Service
public class VideoServiceImpl implements VideoService {
    
    @Value("${files.video}")
    String DIR;

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

            String cleanFileName = StringUtils.cleanPath(filename);
            String cleanDIR = StringUtils.cleanPath(DIR);

            Path path = Paths.get(cleanDIR, cleanFileName);

            System.out.println(path);
            System.out.println(contentType);
 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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
