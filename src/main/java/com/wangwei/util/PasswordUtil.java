package com.wangwei.util;

import org.springframework.util.DigestUtils;

import java.util.Random;

/**
 * @Author: LiJin
 * @Date: 2022/8/20
 * @Description: 加密工具类
 */
public class PasswordUtil {
    //默认的获取盐的方法
    public static String getSalt(){
        return getSalt(10);
    }

    public static String getSalt(int size){
        char[] pool = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for(int i = 0;i < size;i ++){
            sb.append(pool[random.nextInt(pool.length)]);
        }
        return sb.toString();
    }
    //密码拼接并加密
    public static String getPassword(String pass, String salt){
        pass = pass + salt;
        String md5 = DigestUtils.md5DigestAsHex(pass.getBytes());
        return md5;
    }
}
