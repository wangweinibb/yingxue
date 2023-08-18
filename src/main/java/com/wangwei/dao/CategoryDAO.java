package com.wangwei.dao;

import com.wangwei.entity.Category;

import java.util.List;

public interface CategoryDAO {
    public Category selectById(int id);
    public List<Category> selectByLevels(Integer levels,Integer num,Integer size);
    public List<Category> selectByLevels2(Integer levels);
    public List<Category> selectByParentId(Integer parentId,Integer levels,Integer num,Integer size);
    public List<Category> selectByParentId2(Integer parentId,Integer levels);
    public int selectByCount(Category category);
    public void insertAll(Category category);
    public void updateAll(int id,String cateName);
    public void deleteAll(int id);
    public int deleteAll2(Integer id);
}
