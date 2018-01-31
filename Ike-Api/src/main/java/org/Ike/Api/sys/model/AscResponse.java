package org.Ike.Api.sys.model;

public class AscResponse<T> {
	
	private T t;
	
	private Boolean success;
	
	private String message;
	
	public AscResponse(){
		
	}

	public AscResponse(String mes,Boolean success){
		this.setMessage(mes);
		this.setSuccess(success);
	}

	public AscResponse(String mes,T t,Boolean success){
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

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
