package com.ipartek.formacion.model.conections.interfaces;

import java.sql.Connection;

public interface IConexion {
  public void conectar();

  public void desconectar();

  public Connection getConexion();
}
