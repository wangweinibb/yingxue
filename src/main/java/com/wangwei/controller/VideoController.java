package com.wangwei.controller;

import com.wangwei.entity.Video;
import com.wangwei.entity.VideoDto;
import com.wangwei.service.VideoService;
import com.wangwei.util.UploadUtil;
import com.wangwei.vo.Data;
import com.wangwei.vo.Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/api/video")
public class VideoController {
    private final ResourceLoader resourceLoader;

    @Autowired
    private VideoService videoService;

    public VideoController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @RequestMapping("/searchVideo")
    @ResponseBody
    public Vo findVideo(Video video) {
        Vo vo = new Vo();
        int num = (video.getPage() - 1) * video.getSize();
        List<VideoDto> videoDtos = new ArrayList<>();
        for (Video videoDto : videoService.findAll(num, video.getSize())) {
            videoDtos.add(new VideoDto(videoDto.getId(), videoDto.getTitle(), videoDto.getDescription(), videoDto.getCover_path(), videoDto.getVideo_path(), videoDto.getStatus(), videoDto.getCreate_time(), videoDto.getCategory_id(), videoDto.getUser_id(), videoDto.getNum(), videoDto.getPage(), videoDto.getSize(), videoDto.getCategorys(), videoDto.getUsers()));
        }
        try {
            vo.ok(new Data(videoDtos, videoService.findByCount()));
        } catch (Exception e) {
            e.printStackTrace();
            vo.error("网络错误");
        }
        return vo;
    }

    @RequestMapping("/upload")
    @ResponseBody
    public Vo uploadVideo(HttpServletRequest request, VideoDto videoDto, MultipartFile file) {
        Vo vo = new Vo();
        try {
            byte[] videoBytes = file.getBytes();
            String objectName = "upload/" + file.getOriginalFilename(); // 替换为您想要的对象路径
            UploadUtil.upload(objectName, videoBytes);
            videoService.addAll(new Video(null, videoDto.getTitle(), videoDto.getDescription(), "https://new-wangwei.oss-cn-beijing.aliyuncs.com/upload/" + file.getOriginalFilename(), "https://new-wangwei.oss-cn-beijing.aliyuncs.com/upload/" + file.getOriginalFilename(), 1, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), videoDto.getCategoryId(), videoDto.getUserId(), null, null, null, null, null));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vo;
    }
}