package com.ipartek.formacion.bean;

/**
 * Clase de Usuario de al aplicacion.
 * 
 * @author java
 *
 */
public class Usuario {

  protected int codigoUsuario;
  protected String userName;
  protected String password;
  protected String email;
  protected String telefono;

  /**
   * Constructor en blanco de la clase <code>Usuario</code>.
   */
  public Usuario() {
    super();
    setUserName("");
    setPassword("");
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

  public int getCodigoUsuario() {
    return codigoUsuario;
  }

  public void setCodigoUsuario(int codigoUsuario) {
    this.codigoUsuario = codigoUsuario;
  }

}
