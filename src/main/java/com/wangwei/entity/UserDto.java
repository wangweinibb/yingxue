package com.wangwei.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Integer id;
    private String username;
    private String sign;
    private String headImg;
    private String phone;
    private boolean status;
    private String createTime;
    private Integer page;
    private Integer size;
}
