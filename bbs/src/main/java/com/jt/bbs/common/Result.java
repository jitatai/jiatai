package com.jt.bbs.common;

public class Result<T> {

	private int code;
	private String msg;
	private T data;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public Result(int code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
	public Result(int code) {
		super();
		this.code = code;
	}
	public Result(int code, String msg, T data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	
}
