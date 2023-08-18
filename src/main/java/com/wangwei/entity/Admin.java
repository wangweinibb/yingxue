package com.wangwei.entity;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    private Integer id;
    private String username;
    private String password;
    private String salt;
    private Date create_time;
    private Integer num;
    private Integer size;
    private Integer count;
}
