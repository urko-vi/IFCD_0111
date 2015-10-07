package com.ipartek.formacion.service.interfaces;

import com.ipartek.formacion.bean.Curso;
import com.ipartek.formacion.service.exceptions.CursoServiceException;

import java.util.List;

public interface ICursoService {
  // getAll()
  public List<Curso> getAll();

  // getById(int codigoCurso)
  public Curso getById(int codigoCurso) throws CursoServiceException;

  // update(Curso curso)
  public int update(Curso curso) throws CursoServiceException;

  // delete(int codigoCurso)
  public boolean delete(int codigoCurso) throws CursoServiceException;

  // create(Curso curso)
  public int create(Curso curso);

}
