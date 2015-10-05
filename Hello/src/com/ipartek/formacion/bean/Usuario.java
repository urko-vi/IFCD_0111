package com.ipartek.formacion.bean;

public class Usuario {
	private String userName;
	private String password;
	
	
	
	public Usuario() {
		super();
		setUserName("");
		setPassword("");
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
