package com.wangwei.dao;

import com.wangwei.entity.Video;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VideoDAO {
    public Video selectById(@Param("id") int id);
    public List<Video> selectAll(@Param("num") int num,@Param("size") int size);
    public int selectByCount();
    public void insertAll(Video video);
}
