package com.qfedu.fmmall.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.transform.Result;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "ResultVO对象",description = "封装接口返回前端的数据")
public class ResultVO {

    @ApiModelProperty(value = "响应状态码",dataType = "int")
    private int code = 200; // 响应给前端的状态码
    @ApiModelProperty(value = "响应提示信息")
    private String msg; // 响应给前端的信息
    @ApiModelProperty(value = "响应数据")
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
