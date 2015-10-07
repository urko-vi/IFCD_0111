package com.ipartek.formacion.service.interfaces;

import com.ipartek.formacion.bean.Curso;

import java.util.List;

public interface ICursoService {
  // getAll()
  public List<Curso> getAll();

  // getById(int codigoCurso)
  public Curso getById(int codigoCurso);

  // update(Curso curso)
  public int update(Curso curso);

  // delete(int codigoCurso)
  public boolean delete(int codigoCurso);

  // create(Curso curso)
  public int create(Curso curso);

}
