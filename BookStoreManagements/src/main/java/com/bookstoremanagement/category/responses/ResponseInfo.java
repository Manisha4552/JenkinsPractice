package com.bookstoremanagement.category.responses;

import org.springframework.http.HttpStatus;

public class ResponseInfo {
	private String uri;
	private int statusCode;
	private HttpStatus statusType;
	private String msg;
	public ResponseInfo(String uri, int statusCode, HttpStatus statusType, String msg) {
		super();
		this.uri = uri;
		this.statusCode = statusCode;
		this.statusType = statusType;
		this.msg = msg;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public HttpStatus getStatusType() {
		return statusType;
	}
	public void setStatusType(HttpStatus statusType) {
		this.statusType = statusType;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public ResponseInfo() {
		
	}
}
