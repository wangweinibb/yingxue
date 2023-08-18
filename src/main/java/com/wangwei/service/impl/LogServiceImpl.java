package com.wangwei.service.impl;

import com.wangwei.dao.LogDAO;
import com.wangwei.entity.Log;
import com.wangwei.service.LogService;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogDAO logDAO;
    @Override
//    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Log findById(int id) {
        return logDAO.selectById(id);
    }

    @Override
//    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Log> findAll(Log log) {
        return logDAO.selectAll(log);
    }

    @Override
//    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public int findByCount() {
        return logDAO.selectByCount();
    }

    @Override
    public void addLog(Log log) {
        logDAO.insertLog(log);
    }
}
