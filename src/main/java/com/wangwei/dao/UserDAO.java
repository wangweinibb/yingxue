package com.wangwei.dao;

import com.wangwei.entity.User;

import java.util.List;

public interface UserDAO {
    public User selectById(int id);
    public int selectByCount();
    public List<User> selectAll(int num,int size);
    public void updateStatus(int id,int status);
}
