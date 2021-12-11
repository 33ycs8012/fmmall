package com.qfedu.fmmall.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.transform.Result;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultVO {

    private int code = 200; // 响应给前端的状态码
    private String msg; // 响应给前端的信息
    private Object data; // 响应给前端的数据

    public static ResultVO ok(int code,String msg,Object data){
        return new ResultVO(code,msg,data);
    }
    public static ResultVO ok(String msg){
        return new ResultVO(msg);
    }
    public static ResultVO error(int code,String msg){
        return new ResultVO(code,msg,null);
    }

    public ResultVO(String msg){
        this.msg = msg;
    }

}
