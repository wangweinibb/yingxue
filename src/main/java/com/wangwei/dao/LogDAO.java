package com.wangwei.dao;

import com.wangwei.entity.Log;

import java.util.List;

public interface LogDAO {
    public Log selectById(int id);
    public List<Log> selectAll(Log log);
    public int selectByCount();
    public void insertLog(Log log);
}
