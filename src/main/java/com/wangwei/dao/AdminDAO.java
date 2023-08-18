package com.wangwei.dao;

import com.wangwei.entity.Admin;

import java.util.List;

public interface AdminDAO {
    public List<Admin> selectAll();
    public Admin selectByUsername(String username);
    public Admin selectByUsernameAndPassword(String username,String password);
    public List<Admin> selectByPageAndSize(int num,int size);
    public int selectByCount();
    public void insertAdmin(Admin admin);
    public void updateAdmin(Admin admin);
    public void delAdmin(int id);
}
