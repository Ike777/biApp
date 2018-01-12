package org.Ike.Api.sys.model;

public class AscResponse<T> {
	
	private T t;
	
	private int success;
	
	private String message;
	
	public AscResponse(){
		
	}

	public AscResponse(String mes,int success){
		this.setMessage(mes);
		this.setSuccess(success);
	}

	public AscResponse(String mes,T t,int success){
		this.setMessage(mes);
		this.setT(t);
		this.setSuccess(success);
	}

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

	public int getSuccess() {
		return success;
	}

	public void setSuccess(int success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
