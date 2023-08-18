package com.wangwei.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    private Integer id;
    private String cateName;
    private Integer levels;
    private Integer parentId;
    private Integer page;
    private Integer size;
    private Integer num;

}
