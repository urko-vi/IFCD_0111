package com.ipartek.formacion.bean.interfaces;

import com.ipartek.formacion.service.exceptions.CursoServiceException;

/**
 * Interfaz para especificar que clases se pueden matricular y desmatricular en un
 * <code>Curso</code>.
 * 
 * @author java
 *
 */
public interface IMatriculable {
  /**
   *
   * @param codigoCurso
   *          <code>int</code> del <code>Curso</code> a Matricularse.
   * @throws CursoServiceException
   *           en el caso de que el codigo del <code>Curso</code> no exista.
   */
  public void matricularCurso(int codigoCurso) throws CursoServiceException;

  /**
   * 
   * @param codigoCurso
   *          <code>int</code> del <code>Curso</code> a desmatricularse.
   * @throws CursoServiceException
   *           en el caso de que el codigo del <code>Curso</code> no exista.
   */
  public void desmatricularCurso(int codigoCurso) throws CursoServiceException;
}
