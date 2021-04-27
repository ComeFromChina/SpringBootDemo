package com.lovemio.mybatisplus.utils;

import java.io.Serializable;

public class Result implements Serializable {
    // 结果标记(true:执行成功 false:执行失败)
    private Boolean flag;
    // 消息状态码
    private Integer code;
    // 消息
    private String msg;
    // 返回数据
    private Object data;

    private Result(Boolean flag, Integer code, String msg, Object data) {
        this.flag = flag;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 响应成功(带返回数据)
     * @param data 返回数据
     * @return Result
     */
    public static Result success(Object data){
        return new Result(true,2000,"响应成功",data);
    }

    /**
     * 响应成功
     * @return Result
     */
    public static Result success(){
        return new Result(true,2000,"响应成功",null);
    }

    /**
     * 响应错误(不带状态码,带消息)
     * @return Result
     */
    public static Result error(String msg){
        return new Result(false,2400,msg,null);
    }

    /**
     * 响应错误(带错误码,消息提醒)
     * @return
     */
    public static Result errorMsg(Integer code,String msg){
        return new Result(false,code,msg,null);
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
