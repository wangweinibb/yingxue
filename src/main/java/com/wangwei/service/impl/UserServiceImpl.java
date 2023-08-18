package com.wangwei.service.impl;

import com.wangwei.dao.UserDAO;
import com.wangwei.entity.User;
import com.wangwei.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;
    @Override
//    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public User findById(int id) {
        return userDAO.selectById(id);
    }

    @Override
//    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public int findByCount() {
        return userDAO.selectByCount();
    }

    @Override
//    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<User> findAll(int num, int size) {
        return userDAO.selectAll(num,size);
    }

    @Override
    public void changeStatus(int id,int status) {
        userDAO.updateStatus(id,status);
    }
}
