package com.ipartek.formacion.model;

import com.ipartek.formacion.model.conections.MySQLConvocatoriaFactory;
import com.ipartek.formacion.model.conections.MySQLCursoFactory;
import com.ipartek.formacion.model.conections.interfaces.IConnectionFactory;
import com.ipartek.formacion.model.dbms.interfaces.IConvocatoriaDAO;
import com.ipartek.formacion.model.dbms.interfaces.ICursoDAO;

public abstract class DAOFactory implements IConnectionFactory {
  public static final int MYSQL_CURSOS = 1;
  public static final int MYSQL_CONVOCATORIAS = 2;

  // ...

  public abstract IConvocatoriaDAO getConvocatoriaDAO(int whichfactory);

  public abstract ICursoDAO getCursoDAO(int whichfactory);

  // .. tantos metodos abstractos como tablas

  public static DAOFactory getDAOFactory(int whichfactory) {
    switch (whichfactory) {
      case MYSQL_CURSOS:
        return MySQLCursoFactory.getInstance();
      case MYSQL_CONVOCATORIAS:
        return MySQLConvocatoriaFactory.getInstance();
      default:
        return null;
    }

  }

}
