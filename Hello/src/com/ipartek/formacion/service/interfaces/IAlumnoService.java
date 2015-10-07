package com.ipartek.formacion.service.interfaces;

import java.util.List;

import com.ipartek.formacion.bean.Alumno;

public interface IAlumnoService {
	public Alumno getById(final int codigo);
	public List<Alumno> getAll();
	public int update(final Alumno al);
	public boolean delete(final int codigo);
	public Alumno create(final Alumno al);

}
