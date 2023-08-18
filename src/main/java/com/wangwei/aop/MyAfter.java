package com.wangwei.aop;

import com.wangwei.entity.Log;
import com.wangwei.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@Aspect
@Component
public class MyAfter {
    @Autowired
    private LogService logService;
    @After("execution(* com.wangwei.controller.*.*(..)) && !execution(* com.wangwei.controller.*.find*(..)) && !target(com.wangwei.controller.LogController)")
    public void after(JoinPoint joinPoint) {
        HttpSession session = getSession();
        String username = (String) session.getAttribute("username");
        String methodName = joinPoint.getSignature().getName();
//        System.out.println("-------------------后置通知--------------------");
//        System.out.println("Session username: " + username);
//        System.out.println("方法名: " + methodName);
//        System.out.println("当前时间: " + new SimpleDateFormat().format(new Date()));
//        System.out.println("-------------------后置通知--------------------");
        try {
            logService.addLog(new Log(null,username,new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()),methodName,1,null,null,null,null,null));
        }catch (Exception e){
            e.printStackTrace();
            logService.addLog(new Log(null,username,new SimpleDateFormat().format(new Date()),methodName,0,null,null,null,null,null));
        }
    }

    // 获取当前请求的 HttpSession
    private HttpSession getSession() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            return attributes.getRequest().getSession();
        }
        return null;
    }
}
