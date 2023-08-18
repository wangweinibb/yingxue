package com.wangwei.vo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Data {
    private List<?> result;
    private int total;
}
