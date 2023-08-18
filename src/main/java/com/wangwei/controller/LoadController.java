package com.wangwei.controller;

import com.wangwei.entity.Admin;
import com.wangwei.service.AdminService;
import com.wangwei.util.VerifyCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;

@Controller
@RequestMapping("/api/admin")
public class LoadController {
    @Autowired
    private AdminService adminService;

//    验证码
    @RequestMapping("/getVerifyImage")
    @ResponseBody
    public HashMap<String, Object> findLoginBygetVerifyImage(HttpServletRequest request) {
        HashMap<String, Object> map = new HashMap<>();
        try {
            String s = VerifyCodeUtil.generateVerifyCode(4);
            String base64Image = VerifyCodeUtil.createBase64Image(s);
            request.getSession().setAttribute("sessionCode", s);
            map.put("status", true);
            map.put("data", base64Image);
        } catch (IOException e) {
            e.printStackTrace();
            map.put("status",false);
            map.put("message","网络错误");
        }
        return map;
    }
//    登录
    @RequestMapping("/login")
    @ResponseBody
    public HashMap<String,Object> findlogin(HttpServletRequest request,@RequestBody Admin admin,String code){
        HashMap<String,Object> map=new HashMap<>();
        HashMap<String,Object> map2=new HashMap<>();
        if (code.equals(request.getSession().getAttribute("sessionCode"))){
                if (adminService.findByUsernameAndPassword(admin.getUsername(),admin.getPassword())!=null){
                    map.put("status",true);
                    map2.put("id",1);
                    map2.put("username",admin.getUsername());
                    map.put("data",map2);
                    request.getSession().setAttribute("username",admin.getUsername());
                }else {
                    System.out.println("帐号密码错误");
                    map.put("status",false);
                    map.put("message","网络错误");
                }
        }else{
            map.put("status",false);
            map.put("message","网络错误");
        }
        return map;
    }
//    退出登录
    @RequestMapping("/logout")
    @ResponseBody
    public HashMap findlogout(HttpServletRequest request){
        HashMap<String,Object> map=new HashMap<>();
        request.getSession().removeAttribute("username");
        map.put("status",true);
        return map;
    }
//    获取登录管理员信息
    @RequestMapping("/me")
    @ResponseBody
    public HashMap<String,Object> findme(HttpServletRequest request){
        HashMap<String,Object> map=new HashMap<>();
        HashMap<String,Object> map2=new HashMap<>();
        if (adminService.findByUsername((String) request.getSession().getAttribute("username"))!=null){
            map.put("status",true);
            map2.put("id",1);
            map2.put("username","admin");
            map.put("data",map2);
        }else {
            map.put("status",false);
            map.put("message","网络错误");
        }
        return map;
    }
}
