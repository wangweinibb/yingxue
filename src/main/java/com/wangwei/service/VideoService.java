package com.wangwei.service;

import com.wangwei.entity.Video;

import java.util.List;

public interface VideoService {
    public Video findById(int id);
    public List<Video> findAll(int num, int size);
    public int findByCount();
    public void addAll(Video video);
}
