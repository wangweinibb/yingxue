package com.wangwei.service;

import com.wangwei.entity.User;

import java.util.List;

public interface UserService {
    public User findById(int id);
    public int findByCount();
    public List<User> findAll(int num,int size);
    public void changeStatus(int id,int status);
}
