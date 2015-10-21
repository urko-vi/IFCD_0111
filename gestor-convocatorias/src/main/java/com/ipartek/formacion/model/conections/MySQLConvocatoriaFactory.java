package com.ipartek.formacion.model.conections;

import com.ipartek.formacion.model.DAOFactory;
import com.ipartek.formacion.model.conections.interfaces.IConexion;
import com.ipartek.formacion.model.dbms.ConvocatoriaDAO;
import com.ipartek.formacion.model.dbms.CursoDAO;
import com.ipartek.formacion.model.dbms.interfaces.IConvocatoriaDAO;
import com.ipartek.formacion.model.dbms.interfaces.ICursoDAO;

public class MySQLConvocatoriaFactory extends DAOFactory {

  private static MySQLConvocatoriaFactory INSTANCE = null;

  private MySQLConvocatoriaFactory() {
    super();
  };

  private synchronized static void createInstance() {
    if (MySQLConvocatoriaFactory.INSTANCE == null) {
      MySQLConvocatoriaFactory.INSTANCE = new MySQLConvocatoriaFactory();
    }
  }

  public static MySQLConvocatoriaFactory getInstance() {
    if (MySQLConvocatoriaFactory.INSTANCE == null) {
      MySQLConvocatoriaFactory.createInstance();
    }
    return MySQLConvocatoriaFactory.INSTANCE;
  }

  @Override
  public IConexion getConection() {

    return new MySQLConvocatoriaConnection();

  }

  @Override
  public Object clone() throws CloneNotSupportedException {
    throw new CloneNotSupportedException();
  }

  @Override
  public IConvocatoriaDAO getConvocatoriaDAO(int whichfactory) {
    // TODO Auto-generated method stub
    return ConvocatoriaDAO.getInstance(whichfactory);
  }

  @Override
  public ICursoDAO getCursoDAO(int whichfactory) {
    // TODO Auto-generated method stub
    return CursoDAO.getInstance(whichfactory);
  }

}
