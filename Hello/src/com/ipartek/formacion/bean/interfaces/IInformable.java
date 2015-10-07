package com.ipartek.formacion.bean.interfaces;

import com.ipartek.formacion.bean.Curso;

/**
 * Interfaz que especifica quien puede solicitar informacion de un curso
 * 
 * @author Administrador
 *
 */
public interface IInformable {
	/**
	 * Metodo que inviandole el codigo del curso devuelve los datos del
	 * <code>Curso</code>curso
	 * 
	 * @param <code>int</code> codigoCurso que se solicita
	 * @return <code>Curso</code>
	 */
	public Curso solicitarInformacion(int codigoCurso);
}
