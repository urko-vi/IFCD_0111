package com.ipartek.formacion.model.dbms;

import com.ipartek.formacion.model.DAOFactory;
import com.ipartek.formacion.model.conections.interfaces.IConexion;
import com.ipartek.formacion.model.dbms.interfaces.IConvocatoriaDAO;
import com.ipartek.formacion.pojo.Convocatoria;
import com.ipartek.formacion.pojo.excepciones.ConvocatoriaException;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class ConvocatoriaDAO implements IConvocatoriaDAO {
  /**
   * Devuelve el metadata de datos.
   */
  private ResultSet rs = null;
  /**
   * Conexion a base de datos.
   */
  private Connection conection = null;
  /**
   * Interfaz de conexion a Base de datos
   */
  private IConexion iconexion = null;
  /**
   * El que ejecuta la sentencia SQL.
   */
  private PreparedStatement ps = null;
  /**
   * Objeto que gestiona un pool de conexiones.
   */
  private DataSource ds = null;

  /**
   * Objeto CallableStatement.
   */
  private CallableStatement cs = null;

  private static ConvocatoriaDAO INSTANCE = null;

  private synchronized static void createInstance(int whichFactory) {
    if (ConvocatoriaDAO.INSTANCE == null) {
      ConvocatoriaDAO.INSTANCE = new ConvocatoriaDAO(whichFactory);
    }
  }

  public static ConvocatoriaDAO getInstance(int whichFactory) {
    if (ConvocatoriaDAO.INSTANCE == null) {
      ConvocatoriaDAO.createInstance(whichFactory);
    }
    return ConvocatoriaDAO.INSTANCE;
  }

  @Override
  public Object clone() throws CloneNotSupportedException {
    throw new CloneNotSupportedException();
  }

  /**
   * 
   * @param whichfactory
   */
  private ConvocatoriaDAO(int whichfactory) {
    // conectaPool();
    iconexion = DAOFactory.getDAOFactory(whichfactory).getConection();
    iconexion.conectar();
    conection = iconexion.getConexion();

  }

  private void conectar() {
    final String DRIVER = "com.mysql.jdbc.Driver";
    final String IP = "locahost/formacion";
    final String URL = "jdbc:mysql://" + IP;
    final String USER = "alumno";
    final String PASSWORD = "alumno";

    // try {
    // Class.forName(DRIVER);
    // conexion = DriverManager.getConnection(URL, USER, PASSWORD);
    /*
     * } catch (ClassNotFoundException e) { // TODO Auto-generated catch block e.printStackTrace();
     * } catch (SQLException e) { // TODO Auto-generated catch block e.printStackTrace(); }
     */
  }

  /*
   * private void desconectar() { if (conexion != null) { try { conexion.close(); } catch
   * (SQLException e) { // TODO Auto-generated catch block e.printStackTrace(); } }
   * 
   * }
   */
  @Override
  public int create(Convocatoria conv) {
    // final String SQL = "INSERT INTO `convocatoria`(`nombre`, `descripcion`) VALUES (?,?) ";
    final String SQL = "{call createConvocatoria(?,?)}";

    int codigo = Convocatoria.CODIGO_CONVOCATORIA;
    // conectamos
    // conectar();
    // realizar la consulta
    try {
      cs = conection.prepareCall(SQL);
      cs.setString(1, conv.getNombre());
      cs.setString(2, conv.getDescripcion());
      // se asocia al crear a una sentencia SQL
      // ps = conexion.prepareStatement(SQL);
      // pasar parametros
      // ps.setString(1, conv.getNombre());
      // ps.setString(2, conv.getDescripcion());
      // ejecutar la sentencia
      codigo = ps.executeUpdate();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return codigo;
  }

  @Override
  public Convocatoria getById(int codigo) {
    final String SQL = "SELECT codigo,nombre,descripcion FROM convocatoria WHERE codigo = ?";
    Convocatoria conv = null;
    conectar();
    try {
      ps = conection.prepareStatement(SQL);
      ps.setInt(1, codigo);
      rs = ps.executeQuery(SQL);
      conv = new Convocatoria();
      while (rs.next()) {
        conv.setCodigo(rs.getInt("codigo"));
        conv.setNombre(rs.getString("nombre"));
        conv.setDescripcion(rs.getString("descripcion"));

      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (ConvocatoriaException e) {

      e.printStackTrace();
    } finally {
      iconexion.desconectar();
    }
    return conv;
  }

  /*
   * private void conectaPool() { if (ds == null) { try {
   * 
   * InitialContext ictx = new InitialContext(); Context ctx = (Context)
   * ictx.lookup("java:/comp/env"); ds = (DataSource) ctx.lookup("jdbc/gestor-convocatorias");
   * iconexion = ds.getConnection(); } catch (NamingException e) { // TODO Auto-generated catch
   * block e.printStackTrace(); } catch (SQLException e) { // TODO Auto-generated catch block
   * e.printStackTrace(); } } }
   */
  @Override
  public List<Convocatoria> getAll() {
    List<Convocatoria> convocatorias = null;
    // final String SQL = "SELECT codigo,nombre,descripcion FROM convocatoria";
    final String SQL = "{call getallConvocatorias()}";
    try {

      // ps = conexion.prepareStatement(SQL);
      cs = conection.prepareCall(SQL);
      // rs = cs.registerOutParameter(1, ORACLE.);
      rs = cs.executeQuery(SQL);

      convocatorias = new ArrayList<Convocatoria>();
      Convocatoria conv = null;
      while (rs.next()) {
        conv = new Convocatoria();
        conv.setCodigo(rs.getInt("idConvocatoria"));
        conv.setNombre(rs.getString("nombre"));
        conv.setDescripcion(rs.getString("descripcion"));
        convocatorias.add(conv);
      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (ConvocatoriaException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {

    }

    return convocatorias;
  }

  @Override
  public int update(Convocatoria conv) {
    int codigo = Convocatoria.CODIGO_CONVOCATORIA;
    final String SQL = "UPDATE convocatoria SET nombre = ?, descripcion = ? WHERE codigo = ?";
    conectar();

    try {
      ps = conection.prepareStatement(SQL);
      ps.setString(1, conv.getNombre());
      ps.setString(2, conv.getDescripcion());
      ps.setInt(3, conv.getCodigo());
      codigo = ps.executeUpdate(SQL);
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      // desconectar();
    }

    return codigo;
  }

  @Override
  public boolean delete(int codigo) {
    boolean exito = false;
    final String SQL = "DELETE FROM convocatoria WHERE codigo = ?";
    conectar();

    try {
      ps = conection.prepareStatement(SQL);
      ps.setInt(1, codigo);
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      // desconectar();
    }

    return exito;
  }
}
