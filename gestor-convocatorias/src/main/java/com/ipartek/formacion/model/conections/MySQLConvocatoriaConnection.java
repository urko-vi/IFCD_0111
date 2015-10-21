package com.ipartek.formacion.model.conections;

import com.ipartek.formacion.model.conections.interfaces.IConexion;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MySQLConvocatoriaConnection implements IConexion {

  private Connection conexion = null;

  @Override
  public void conectar() {
    if (conexion == null) {
      try {
        // contexto del servidor
        InitialContext itx = new InitialContext();
        // obtener el contexto de la app
        Context ctx = (Context) itx.lookup("java:/comp/env");
        // obtenemos el resource con su nombre
        DataSource ds = (DataSource) ctx.lookup("jdbc/gestor-convocatorias");
        conexion = ds.getConnection();
      } catch (NamingException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }

  @Override
  public void desconectar() {
    if (conexion != null) {
      try {
        conexion.close();
        conexion = null;
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }

  @Override
  public Connection getConexion() {
    // TODO Auto-generated method stub
    return conexion;
  }

}
