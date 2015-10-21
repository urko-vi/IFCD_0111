package com.ipartek.formacion.pojo.excepciones;

public class CursoException extends Exception {

  /**
   * 
   */
  private static final long serialVersionUID = 6165229699400263367L;
  /**
   * Código de error al introducir un codigo en la convocatoria.
   * 
   */
  public static final int CODIGO_ERROR_CODIGO_INCORRECTO = 10;

  /**
   * Mensage de error al introducir un codigo de error en al convocatoria.
   */
  public static final String MSG_ERROR_CODIGO_CONVOCATORIA = "Código de error incorrecto";

  private int codigo;

  /**
   * Constructor que provee mensage de error y codigo de error.
   * 
   * @param mensage
   *          <code>String</code> mensage de error.
   * @param codigo
   *          <code>int</code> codigo de error.
   */
  public CursoException(String mensage, final int codigo) {
    super(mensage);
    this.codigo = codigo;
  }

  public int getCodigo() {
    return codigo;
  }

}
