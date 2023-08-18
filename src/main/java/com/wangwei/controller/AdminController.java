package com.wangwei.controller;

import com.wangwei.entity.Admin;
import com.wangwei.service.AdminService;
import com.wangwei.vo_admin.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    //    分页查询
    @ResponseBody
    @RequestMapping("/queryByPage")
    public HashMap<String, Object> findAdminByPage(int page, int size) {
        HashMap<String, Object> map = new HashMap<>();
        try {
            int num = (page - 1) * size;
            int total2 = adminService.findByCount();
            List<Result> results = new ArrayList<>();
            for (Admin admin : adminService.findByPageAndSize(num, size)) {
                results.add(new Result(admin.getId(), admin.getUsername()));
            }
            HashMap<String, Object> data = new HashMap<>();
            data.put("result", results);
            data.put("total", total2);
            map.put("status", true);
            map.put("data", data);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status", false);
            map.put("message", "网络错误");
        }
        return map;
    }

    //    添加管理员
    @ResponseBody
    @RequestMapping("/addAdmin")
    public HashMap<String, Object> addAdmin( @RequestBody Admin admin) {
        HashMap<String,Object> map=new HashMap<>();
        try {
            adminService.addAdmin(new Admin(null, admin.getUsername(), admin.getPassword(), null, new Date(), null, null, null));
            map.put("status",true);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",false);
            map.put("message","网络错误");
        }
        return map;
    }
    //修改管理员密码
    @ResponseBody
    @RequestMapping("/changePassword")
    public HashMap changeAdminByPassword(@RequestBody Admin admin){
        HashMap<String,Object> map=new HashMap<>();
        try {
            adminService.changeAdmin(admin);
            map.put("status",true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("status",false);
            map.put("message","网络错误");
        }
        return map;
    }
    //删除管理员
    @ResponseBody
    @RequestMapping("/deleteAdmin")
    public HashMap deleteAdminById(int id){
        HashMap<String,Object> map=new HashMap<>();
        try {
            adminService.removeAdmin(id);
            map.put("status",true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("status",false);
            map.put("message","网络错误");
        }
        return map;
    }
}
