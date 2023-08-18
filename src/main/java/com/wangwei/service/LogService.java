package com.wangwei.service;

import com.wangwei.entity.Log;

import java.util.List;

public interface LogService {
    public Log findById(int id);
    public List<Log> findAll(Log log);
    public int findByCount();
    public void addLog(Log log);
}
