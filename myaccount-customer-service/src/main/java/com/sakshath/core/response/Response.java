package com.sakshath.core.response;

import java.util.List;
import java.util.Map;

import com.sakshath.core.request.ErrorDetails;

public class Response<T> {
	private String code;
	private String message;
	private List<T> list;
	private Map<Integer, T> map;
	private List<ErrorDetails> error;
	private String token;

	public Response() {
		super();
	}

	/**
	 * @param code
	 * @param message
	 */
	public Response(String code, String message,List<T> list) {
		super();
		this.code = code;
		this.message = message;
		this.list=list;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public List<ErrorDetails> getError() {
		return error;
	}

	public void setError(List<ErrorDetails> error) {
		this.error = error;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Map<Integer, T> getMap() {
		return map;
	}

	public void setMap(Map<Integer, T> map) {
		this.map = map;
	}

	@Override
	public String toString() {
		return "Response [code=" + code + ", message=" + message + ", list=" + list + ", map=" + map + ", error="
				+ error + ", token=" + token + "]";
	}
	
}

