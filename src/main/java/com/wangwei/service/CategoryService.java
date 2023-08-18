package com.wangwei.service;

import com.wangwei.entity.Category;

import java.util.List;

public interface CategoryService {
    public Category findById(int id);
    public List<Category> findByLevels(Integer levels, Integer num, Integer size);
    public List<Category> findByLevels2(Integer levels);
    public List<Category> findByParentId(Integer parentId,Integer levels,Integer num,Integer size);
    public List<Category> findByParentId2(Integer parentId,Integer levels);
    public int findByCount(Category category);
    public void addAll(Category category);
    public void changeAll(int id,String cateName);
    public void removeAll(int id);
    public int removeAll2(Integer id);
}
