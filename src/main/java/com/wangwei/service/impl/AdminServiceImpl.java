package com.wangwei.service.impl;

import com.wangwei.dao.AdminDAO;
import com.wangwei.entity.Admin;
import com.wangwei.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDAO adminDAO;
    @Override
//    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Admin> findAll() {
        return adminDAO.selectAll();
    }

    @Override
//    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Admin findByUsername(String username) {
        return adminDAO.selectByUsername(username);
    }

    @Override
//    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Admin findByUsernameAndPassword(String username, String password) {
        return adminDAO.selectByUsernameAndPassword(username,password);
    }

    @Override
//    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Admin> findByPageAndSize(int page, int size) {
        return adminDAO.selectByPageAndSize(page,size);
    }

    @Override
//    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public int findByCount() {
        return adminDAO.selectByCount();
    }

    @Override
    public void addAdmin(Admin admin) {
        adminDAO.insertAdmin(admin);
    }

    @Override
    public void changeAdmin(Admin admin) {
        adminDAO.updateAdmin(admin);
    }

    @Override
    public void removeAdmin(int id) {
        adminDAO.delAdmin(id);
    }
}
