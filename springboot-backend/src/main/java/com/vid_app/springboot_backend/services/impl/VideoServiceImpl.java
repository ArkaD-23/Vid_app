package com.vid_app.springboot_backend.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vid_app.springboot_backend.entities.Video;
import com.vid_app.springboot_backend.services.VideoService;

@Service
public class VideoServiceImpl implements VideoService {

    @Override
    public Video save(Video video, Video file) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
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
