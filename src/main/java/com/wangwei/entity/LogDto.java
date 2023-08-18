package com.wangwei.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogDto {
    private Integer id;
    private String adminName;
    private String createTime;
    private String methodName;
    private Integer optionStatus;
}
