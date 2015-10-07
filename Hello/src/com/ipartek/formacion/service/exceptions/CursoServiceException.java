package com.ipartek.formacion.service.exceptions;

/**
 * <code>Exception</code> que sirve para controlar los errores de la clase <code>CursoService</code>
 * .
 *
 * @author Urko
 *
 */
public class CursoServiceException extends Exception {

  private static final long serialVersionUID = 1L;
  /**
   * Codigo de error de <code>Curso</code> no encontrado.
   */
  public static final int COD_CURSO_NO_ENCONTRADO = 10;

  public static final String MSG_CURSO_NO_ENCONTRADO = "Curso no encontrado";
  private transient int codigo;

  public CursoServiceException(String mensage, int codigo) {
    super(mensage);
    this.codigo = codigo;
  }

  public CursoServiceException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

  public CursoServiceException(String message, Throwable cause) {
    super(message, cause);
  }

  public CursoServiceException(String message) {
    super(message);
  }

  public CursoServiceException(Throwable cause) {
    super(cause);
  }

  public int getCodigo() {
    return codigo;
  }
}
