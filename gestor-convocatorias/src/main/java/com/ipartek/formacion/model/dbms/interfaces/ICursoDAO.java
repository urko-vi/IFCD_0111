package com.ipartek.formacion.model.dbms.interfaces;

import com.ipartek.formacion.pojo.Curso;

import java.util.List;

public interface ICursoDAO {
  // CREATE
  public int create(Curso curso);

  // READ --> ReadByID y GetAll()
  public Curso getById(int codigo);

  public List<Curso> getAll();

  // UPDATE
  public int update(Curso curso);

  // DELETE
  public boolean delete(int curso);

}
