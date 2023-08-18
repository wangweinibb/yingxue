package com.wangwei.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class Vo {
    private Object status;
    private Object data;
    private Object message;

    public void ok(){
        status = true;
    }

    public void ok(Object tmpData){
        status = true;
        data = tmpData;
    }

    public void error(){
        status = false;
    }

    public void error(Object tmpMsg){
        status = false;
        message = tmpMsg;
    }
}
