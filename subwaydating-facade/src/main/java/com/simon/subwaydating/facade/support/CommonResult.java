package com.simon.subwaydating.facade.support;

/**
 * @version: java version 1.7+
 * @Author : Simon
 * @Explain :外部接口响应实体
 * @contact:
 * @Time : 2018/8/29 15:04
 * @File : CommonResult
 * @Software: IntelliJ IDEA 2017.3.2
 */
public class CommonResult<T> {
    /**
     * 前端请求响应码，0：成功，-1：失败
     */
    private String status;
    /**
     * 接口响应状态码（可选）
     */
    private String code;
    /**
     * 接口响应msg
     */
    private String msg;
    /**
     * 接口响应内容
     */
    private T     re;

    public CommonResult(){

    }

    public CommonResult(String status, String msg) {
        super();
        this.status = status;
        this.msg = msg;
    }

    public CommonResult(String status, String msg,T data) {
        super();
        this.status = status;
        this.msg = msg;
        this.re = data;
    }

    public CommonResult(String status, String code, String msg, T data) {
        super();
        this.status = status;
        this.code = code;
        this.msg = msg;
        this.re = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getRe() {
        return re;
    }

    public void setRe(T re) {
        this.re = re;
    }

    @Override
    public String toString() {
        return "CommonResult{" +
                "status='" + status + '\'' +
                ", code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", re=" + re +
                '}' ;
    }
}
