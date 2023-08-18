package com.wangwei.vo_admin;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
public class Data {
    private List<Result> results;
    private int total;
}
