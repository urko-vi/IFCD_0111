package com.ipartek.formacion.model.conections;

import com.ipartek.formacion.model.DAOFactory;
import com.ipartek.formacion.model.conections.interfaces.IConexion;
import com.ipartek.formacion.model.dbms.ConvocatoriaDAO;
import com.ipartek.formacion.model.dbms.interfaces.IConvocatoriaDAO;
import com.ipartek.formacion.model.dbms.interfaces.ICursoDAO;

public class MySQLCursoFactory extends DAOFactory {

  private static MySQLCursoFactory INSTANCE = null;

  private MySQLCursoFactory() {
    super();
  };

  private synchronized static void createInstance() {
    if (MySQLCursoFactory.INSTANCE == null) {
      MySQLCursoFactory.INSTANCE = new MySQLCursoFactory();
    }
  }

  public static MySQLCursoFactory getInstance() {
    if (MySQLCursoFactory.INSTANCE == null) {
      MySQLCursoFactory.createInstance();
    }
    return MySQLCursoFactory.INSTANCE;
  }

  @Override
  public IConexion getConection() {
    // TODO Auto-generated method stub
    return new MySQLCursoConnection();

  }

  @Override
  public Object clone() throws CloneNotSupportedException {
    throw new CloneNotSupportedException();
  }

  @Override
  public IConvocatoriaDAO getConvocatoriaDAO(int whichfactory) {

    return ConvocatoriaDAO.getInstance(whichfactory);
  }

  @Override
  public ICursoDAO getCursoDAO(int whichfactory) {
    // TODO Auto-generated method stub
    return null;
  }

}
