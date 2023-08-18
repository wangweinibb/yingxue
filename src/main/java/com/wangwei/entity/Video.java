package com.wangwei.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Video {
    private Integer id;
    private String title;
    private String description;
    private String cover_path;
    private String video_path;
    private Integer status;
    private String create_time;
    private Integer category_id;
    private Integer user_id;
    private Integer num;
    private Integer page;
    private Integer size;
    private Category categorys;
    private User users;
}
