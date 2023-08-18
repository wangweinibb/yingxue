package com.wangwei.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VideoDto {
    private Integer id;
    private String title;
    private String description;
    private String coverPath;
    private String videoPath;
    private Integer status;
    private String createTime;
    private Integer categoryId;
    private Integer userId;
    private Integer num;
    private Integer page;
    private Integer size;
    private Category category;
    private User user;
}
