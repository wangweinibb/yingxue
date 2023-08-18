package com.wangwei.controller;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.wangwei.entity.User;
import com.wangwei.entity.UserDto;
import com.wangwei.service.UserService;
import com.wangwei.util.HttpCheckUtility;
import com.wangwei.vo.Data;
import com.wangwei.vo.Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

import static com.wangwei.util.HttpSendUtility.sendGetRequest;

@Controller
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    //    分页查询所有用户
    @RequestMapping("/queryByPage")
    @ResponseBody
    public Vo findUserByPage(int page, int size) {
        Vo vo = new Vo();
        List<UserDto> userDtos = new ArrayList<>();
        int num = (page - 1) * size;
        for (User user : userService.findAll(0, 5)) {
            if (user.getStatus() == 1) {
                userDtos.add(new UserDto(user.getId(), user.getUsername(), user.getSign(), user.getHead_img(), user.getPhone(), true, user.getCreate_time(), null, null));
            } else {
                userDtos.add(new UserDto(user.getId(), user.getUsername(), user.getSign(), user.getHead_img(), user.getPhone(), false, user.getCreate_time(), null, null));
            }
        }
        try {
            vo.ok(new Data(userDtos, userService.findByCount()));
        } catch (Exception e) {
            e.printStackTrace();
            vo.error("网络错误");
        }
        return vo;
    }

    //    修改用户可用状态
    @RequestMapping("/toggleStatus")
    @ResponseBody
    public Vo changeUserStatus(@RequestBody UserDto userDto) {
        Vo vo = new Vo();
        Integer sj_status = null;
        if (userDto.isStatus()) {
            sj_status = 1;
        } else {
            sj_status = 0;
        }
        try {
            userService.changeStatus(userDto.getId(), sj_status);
            vo.ok();
        } catch (Exception e) {
            e.printStackTrace();
            vo.error("网络错误");
        }
        return vo;
    }

    //    发送短信验证码
    @RequestMapping("/sendVerificationCode")
    @ResponseBody
    public Vo sendVerificationCode(@RequestBody User user) {
        Vo vo = new Vo();
        System.out.println(user.getPhone());
        try {
//            api接口
            String url = "http://zhxy.xhe.cn/app/sendMobileMessage";
            String mobile = user.getPhone();
            String userId = "0";
            long time = 1690857320330L;
            String digest = "fa0ba21f652ea3adf546307ee37aa17c";
            int random = 724726;
            String response = sendGetRequest(url, mobile, userId, time, digest, random);
            System.out.println(response);
            JsonObject jsonResponse = JsonParser.parseString(response).getAsJsonObject();
            String message = jsonResponse.get("success").getAsString();
            System.out.println("响应消息: " + message);

            vo.ok();
        } catch (Exception e) {
            e.printStackTrace();
            vo.error("网络错误");
        }
        return vo;
    }
//    获取手机短信验证码
    @RequestMapping("/checkVerificationCode")
    @ResponseBody
    public Vo checkVerificationCode(@RequestBody User user){
        Vo vo=new Vo();
        try {
            System.out.println(user.getPhone());
            System.out.println(user.getCode());
            String url = "http://zhxy.xhe.cn/app/registerorlogin";
            String mobile=user.getPhone();
            String code=user.getCode();
            String queryString = "mobile="+mobile+"&code="+code+"&regType=mobileFrom";
            String response = HttpCheckUtility.sendGetRequest(url, queryString);
            System.out.println(response);
            JsonObject jsonResponse = JsonParser.parseString(response).getAsJsonObject();
            String message = jsonResponse.get("success").getAsString();
            System.out.println("响应消息: " + message);
            if (message.equals("true")){
                vo.ok();
            }else {
                vo.error("验证码错误");
            }
        }catch (Exception e){
            e.printStackTrace();
            vo.error("网络错误");
        }
        return vo;
    }
}
