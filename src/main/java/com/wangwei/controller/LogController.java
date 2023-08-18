package com.wangwei.controller;

import com.wangwei.entity.Log;
import com.wangwei.entity.LogDto;
import com.wangwei.service.LogService;
import com.wangwei.vo.Data;
import com.wangwei.vo.Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api/log")
public class LogController {
    @Autowired
    private LogService logService;
    @RequestMapping("/queryByPage")
    @ResponseBody
    public Vo findLogByPage(Log log){
        Vo vo=new Vo();
        int num=(log.getPage()-1)*log.getSize();
        List<LogDto> logDtos = new ArrayList<>();
        try {
            for (Log logDto : logService.findAll(new Log(null, null, null, null, null, num, null, log.getSize(), log.getStartTime(), log.getEndTime()))) {
                logDtos.add(new LogDto(logDto.getId(),logDto.getAdmin_name(),logDto.getCreate_time(),logDto.getMethod_name(),logDto.getOption_status()));
            }
            vo.ok(new Data(logDtos,logService.findByCount()));
        }catch (Exception e){
            e.printStackTrace();
            vo.error("网络错误");
        }
        return vo;
    }
}
