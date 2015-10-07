package com.ipartek.formacion.bean.interfaces;

import com.ipartek.formacion.service.exceptions.CursoServiceException;

public interface IMatriculable {
  /**
   *
   * @param codigoCurso
   * @throws CursoServiceException
   */
  public void matricularCurso(int codigoCurso) throws CursoServiceException;

  /**
   * 
   * @param codigoCurso
   * @throws CursoServiceException
   */
  public void desmatricularCurso(int codigoCurso) throws CursoServiceException;
}
