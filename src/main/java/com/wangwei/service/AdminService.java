package com.wangwei.service;

import com.wangwei.entity.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminService {
    public List<Admin> findAll();
    public Admin findByUsername(String username);
    public Admin findByUsernameAndPassword(String username,String password);
    public List<Admin> findByPageAndSize(@Param("num") int num,@Param("size") int size);
    public int findByCount();
    public void addAdmin(Admin admin);
    public void changeAdmin(Admin admin);
    public void removeAdmin(int id);
}