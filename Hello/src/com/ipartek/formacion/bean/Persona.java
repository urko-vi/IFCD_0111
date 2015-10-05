package com.ipartek.formacion.bean;

public abstract class Persona {
	protected String email;
	protected String telefono;
	
	
	
	protected abstract Curso solicitarInformacion();
	
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
}
