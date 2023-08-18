package com.wangwei.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Log {
    private Integer id;
    private String admin_name;
    private String create_time;
    private String method_name;
    private Integer option_status;
    private Integer num;
    private Integer page;
    private Integer size;
    private String startTime;
    private String endTime;
}
