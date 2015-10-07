package com.ipartek.formacion.bean;

public abstract class Persona {
	protected String email;
	protected String telefono;

	public Persona() {
		setEmail("");
		setTelefono("");
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(final String telefono) {
		this.telefono = telefono;
	}

}
