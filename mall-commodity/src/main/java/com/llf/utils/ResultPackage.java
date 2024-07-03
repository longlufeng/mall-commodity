package com.llf.utils;

import java.io.Serializable;
 
public class ResultPackage implements Serializable {
 
    private static final long serialVersionUID = -3948389268046368059L;
 
    private String code = "200";
 
    private String msg = "交易成功";
 
    private Object data;
    
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

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public ResultPackage() {
    }
 
    public ResultPackage(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
 
    public static ResultPackage success() {
        ResultPackage result = new ResultPackage();
        return result;
    }
 
    public static ResultPackage success(Object data) {
        ResultPackage result = new ResultPackage();
        result.setData(data);
        return result;
    }
    
    public static ResultPackage failure() {
        ResultPackage result = new ResultPackage();
        result.setCode("999999");
        result.setMsg("交易失败");
        return result;
    }
 
    public static ResultPackage failure(String code,String msg) {
        ResultPackage result = new ResultPackage();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
 
    public static ResultPackage failure(String code,String msg, Object data) {
        ResultPackage result = new ResultPackage();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }
 
}