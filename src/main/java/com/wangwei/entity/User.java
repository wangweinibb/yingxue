package com.wangwei.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String username;
    private String sign;
    private String head_img;
    private String phone;
    private String code;
    private Integer status;
    private String create_time;
    private Integer page;
    private Integer size;
}
