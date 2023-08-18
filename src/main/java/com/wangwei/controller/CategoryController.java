package com.wangwei.controller;

import com.wangwei.entity.Category;
import com.wangwei.service.CategoryService;
import com.wangwei.vo.Data;
import com.wangwei.vo.Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    //查询某级类别
    @GetMapping("/queryLevels")
    @ResponseBody
    public Vo findCategoryByLevels(Category category) {
        Vo vo = new Vo();
        try {
//            是否需要分页
            if (category.getPage() == null && category.getSize() == null) {
                if (category.getParentId() == null) {
                    vo.ok(categoryService.findByLevels2(category.getLevels()));
                } else {
                    vo.ok(categoryService.findByParentId2(category.getParentId(), category.getLevels()));
                }
            } else {
                int num = (category.getPage() - 1) * category.getSize();
                if (category.getParentId() == null) {
                    vo.ok(new Data(categoryService.findByLevels(category.getLevels(),num,category.getSize()),categoryService.findByCount(new Category(null,null,category.getLevels(),category.getParentId(),null,null,null))));
                } else {
                    vo.ok(new Data(categoryService.findByParentId(category.getParentId(),category.getLevels(),num,category.getSize()),categoryService.findByCount(new Category(null,null,category.getLevels(),category.getParentId(),null,null,null))));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            vo.error("网络错误");
        }
        return vo;
    }

    @RequestMapping("/addCategory")
    @ResponseBody
    public Vo addCategory(@RequestBody Category category) {
        Vo vo = new Vo();
        try {
            categoryService.addAll(category);
            vo.ok();
        } catch (Exception e) {
            e.printStackTrace();
            vo.error("网络错误");
        }
        return vo;
    }

    @RequestMapping("/editName")
    @ResponseBody
    public Vo changeCategoryByName(@RequestBody Category category) {
        Vo vo = new Vo();
        try {
            categoryService.changeAll(category.getId(), category.getCateName());
            vo.ok();
        } catch (Exception e) {
            e.printStackTrace();
            vo.error("网络错误");
        }
        return vo;
    }

    @RequestMapping("/deleteCategory")
    @ResponseBody
    public Vo deleteCategoryById(Category category) {
        Vo vo = new Vo();
        try {
            if (categoryService.removeAll2(category.getId())==0){
                categoryService.removeAll(category.getId());
                vo.ok();
            }else {
             vo.error("存在二级类别");
            }
        } catch (Exception e) {
            e.printStackTrace();
            vo.error("删除失败");
        }
        return vo;
    }
}
