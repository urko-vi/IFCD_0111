package com.ipartek.formacion.model.dbms.interfaces;

import com.ipartek.formacion.pojo.Convocatoria;

import java.util.List;

public interface IConvocatoriaDAO {
  // CREATE
  public int create(Convocatoria conv);

  // READ --> ReadByID y GetAll()
  public Convocatoria getById(int codigo);

  public List<Convocatoria> getAll();

  // UPDATE
  public int update(Convocatoria conv);

  // DELETE
  public boolean delete(int codigo);

}
