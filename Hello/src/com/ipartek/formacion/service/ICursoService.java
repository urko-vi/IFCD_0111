package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.bean.Curso;

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
