package com.ipartek.formacion.service.interfaces;

import java.util.List;

import com.ipartek.formacion.bean.Alumno;

public interface IAlumnoService {
	/**
	 * @param codigo
	 * @return
	 */
	public Alumno getById(final int codigo);

	/**
	 * @return
	 */
	public List<Alumno> getAll();

	/**
	 * @param al
	 * @return
	 */
	public int update(final Alumno al);

	/**
	 * @param codigo
	 * @return
	 */
	public boolean delete(final int codigo);

	/**
	 * @param al
	 * @return
	 */
	public int create(final Alumno al);

}
