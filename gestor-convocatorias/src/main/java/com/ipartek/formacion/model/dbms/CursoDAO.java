package com.ipartek.formacion.model.dbms;

import com.ipartek.formacion.model.DAOFactory;
import com.ipartek.formacion.model.conections.interfaces.IConexion;
import com.ipartek.formacion.model.dbms.interfaces.ICursoDAO;
import com.ipartek.formacion.pojo.Curso;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO implements ICursoDAO {
  private IConexion iconexion = null;
  private Connection conexion = null;
  private static CursoDAO INSTANCE = null;
  private CallableStatement cs = null;
  private PreparedStatement ps = null;

  private CursoDAO(int whichfactory) {
    iconexion = DAOFactory.getDAOFactory(whichfactory).getConection();
    iconexion.conectar();
    conexion = iconexion.getConexion();

  }

  private synchronized static void createInstance(int whichFactory) {
    if (CursoDAO.INSTANCE == null) {
      CursoDAO.INSTANCE = new CursoDAO(whichFactory);
    }
  }

  public static CursoDAO getInstance(int whichFactory) {
    if (CursoDAO.INSTANCE == null) {
      CursoDAO.createInstance(whichFactory);
    }
    return CursoDAO.INSTANCE;
  }

  @Override
  public Object clone() throws CloneNotSupportedException {
    throw new CloneNotSupportedException();
  }

  @Override
  public int create(Curso curso) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public Curso getById(int codigo) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Curso> getAll() {
    List<Curso> cursos = null;
    Curso curso = null;
    ResultSet rs = null;
    final String SQL = "{call cursoGetAll()}";
    try {
      cs = conexion.prepareCall(SQL);
      rs = cs.executeQuery();

      cursos = new ArrayList<Curso>();
      while (rs.next()) {

        curso = new Curso();
        curso.setCodigo(rs.getInt("codigo"));
        curso.setNombre(rs.getString("nombre"));
        curso.setDescripcion(rs.getString("descripcion"));
        cursos.add(curso);
      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return cursos;
  }

  @Override
  public int update(Curso curso) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public boolean delete(int curso) {
    // TODO Auto-generated method stub
    return false;
  }

}
