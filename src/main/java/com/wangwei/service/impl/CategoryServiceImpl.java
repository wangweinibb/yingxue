package com.wangwei.service.impl;

import com.wangwei.dao.CategoryDAO;
import com.wangwei.entity.Category;
import com.wangwei.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDAO categoryDAO;
    @Override
//    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Category findById(int id) {
        return categoryDAO.selectById(id);
    }

    @Override
//    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Category> findByLevels(Integer levels, Integer num, Integer size) {
        return categoryDAO.selectByLevels(levels,num,size);
    }

    @Override
    public List<Category> findByLevels2(Integer levels) {
        return categoryDAO.selectByLevels2(levels);
    }

    @Override
//    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Category> findByParentId(Integer parentId,Integer levels,Integer num,Integer size) {
        return categoryDAO.selectByParentId(parentId,levels,num,size);
    }

    @Override
    public List<Category> findByParentId2(Integer parentId, Integer levels) {
        return categoryDAO.selectByParentId2(parentId,levels);
    }

    @Override
//    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public int findByCount(Category category) {
        return categoryDAO.selectByCount(category);
    }

    @Override
    public void addAll(Category category) {
        categoryDAO.insertAll(category);
    }

    @Override
    public void changeAll(int id, String cateName) {
        categoryDAO.updateAll(id,cateName);
    }

    @Override
    public void removeAll(int id) {
        categoryDAO.deleteAll(id);
    }

    @Override
    public int removeAll2(Integer id) {
        return categoryDAO.deleteAll2(id);
    }
}
