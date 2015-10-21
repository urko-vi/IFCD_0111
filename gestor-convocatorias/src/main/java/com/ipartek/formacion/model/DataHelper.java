package com.ipartek.formacion.model;

import com.ipartek.formacion.pojo.Convocatoria;
import com.ipartek.formacion.pojo.excepciones.ConvocatoriaException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataHelper {

  private static final String DRIVER = "com.mysql.jdbc.Driver";
  private static final String IP = "locahost/formacion";
  private static final String URL = "jdbc:mysql://" + DataHelper.IP;
  private static final String USER = "alumno";
  private static final String PASSWORD = "alumno";

  /**
   * Es para las updates, inserts y las deletes.
   * 
   * @param SQL
   * @return
   */
  public int ejecutarSentenciaSQL(final String SQL) {
    Connection conexion = null;
    Statement sentencia = null;
    int colAfectadas = -1;
    // conexion
    try {
      Class.forName(DataHelper.DRIVER);
      conexion = DriverManager.getConnection(DataHelper.URL, DataHelper.USER, DataHelper.PASSWORD);

      // cargamos el objeto Stament que es el que ejecuta la sentencia
      sentencia = conexion.createStatement();
      // ejecuta la sentencia
      colAfectadas = sentencia.executeUpdate(SQL);
      // se recogen los datos (parseandolo a clases java)
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      if (sentencia != null) {
        try {
          sentencia.close();
        } catch (SQLException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
      if (conexion != null) {
        try {
          conexion.close();
        } catch (SQLException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
    }

    return colAfectadas;
  }

  /**
   * Sentencia para las selects.
   * 
   * @param SQL
   * @return
   */
  public List<Convocatoria> seleccionarConvocatorias(String SQL) {
    List<Convocatoria> convocatorias = null;
    Connection conexion = null;
    Statement sentencia = null;
    ResultSet rs = null;
    try {
      // cargamos el driver de Base de Datos
      Class.forName(DataHelper.DRIVER);
      // generamos la conexion
      conexion = DriverManager.getConnection(DataHelper.URL, DataHelper.USER, DataHelper.PASSWORD);
      // cargamos el objeto Stament que es el que ejecuta la sentencia
      sentencia = conexion.createStatement();
      // ejecuta la sentencia
      rs = sentencia.executeQuery(SQL);
      // parseamos a objetos java
      Convocatoria convocatoria = null;
      convocatorias = new ArrayList<Convocatoria>();
      while (rs.next()) {
        convocatoria = new Convocatoria();
        convocatoria.setCodigo(rs.getInt("codigo"));
        convocatoria.setDescripcion(rs.getString("descripcion"));
        convocatoria.setNombre(rs.getString("nombre"));

        convocatorias.add(convocatoria);
      }
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (ConvocatoriaException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      if (sentencia != null) {
        try {
          sentencia.close();
        } catch (SQLException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
      if (conexion != null) {
        try {
          conexion.close();
        } catch (SQLException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
    }

    return convocatorias;

  }
}
