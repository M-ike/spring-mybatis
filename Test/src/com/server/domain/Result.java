package com.server.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Result {
	
	//�?级错误码
	private String errorCode;
	//提示信息
	private String errorMsg;
	//业务错误�?
	private String returnCode;
	private String busiData;
	
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public String getReturnCode() {
		return returnCode;
	}
	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}
	public String getBusiData() {
		return busiData;
	}
	public void setBusiData(String busiData) {
		this.busiData = busiData;
	}
	
	public Result(String errorCode, String errorMsg) {
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}
	
	public Result() {
	}
	
	public static Result error() {
		return new Result();
	}
	
	public static Result error(String errorCode, String errorMsg) {
		return new Result(errorCode, errorMsg);
	}
	
	public static Result success() {
		return Result.success("处理成功");
	}
	
	public static Result success(String msg) {
		return new Result("0000", msg);
	}
}
