package com.wangwei.service.impl;

import com.wangwei.dao.VideoDAO;
import com.wangwei.entity.Video;
import com.wangwei.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoDAO videoDAO;
    @Override
//    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Video findById(int id) {
        return videoDAO.selectById(id);
    }

    @Override
//    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Video> findAll(int num, int size) {
        return videoDAO.selectAll(num,size);
    }

    @Override
//    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public int findByCount() {
        return videoDAO.selectByCount();
    }

    @Override
    public void addAll(Video video) {
        videoDAO.insertAll(video);
    }
}
