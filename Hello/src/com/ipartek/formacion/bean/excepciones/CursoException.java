package com.ipartek.formacion.bean.excepciones;

/**
 * Es una <code>Exception</code> encargada de gestionar los errores de <code>Curso</code>.
 * 
 * @author java
 *
 */
public class CursoException extends Exception {

  private static final long serialVersionUID = 1L;

  /**
   * {@code int} Código de la excepción.
   */
  private transient int codigo;
  /**
   * {@code int} Constante de código de error del código de curso.
   */
  public static final int COD_ERROR_CURSO = 10;

  /**
   * {@code int} Constante de código de error del precio del curso.
   */
  public static final int COD_ERROR_PRECIO = 20;
  /**
   * {@code String} constante del texto del mensage del codigo de curso.
   */
  public static final String MSG_ERROR_CODIGO = "El código introducido no es correcto";
  /**
   * {@code String} constante del texto del mensaje del precio del curso.
   */
  public static final String MSG_ERROR_PRECIO = "El precio introducido es incorrecto";

  public CursoException() {
    super();
  }

  public CursoException(final String mensage, final int pcodigo) {
    super(mensage);
    codigo = pcodigo;
  }

  public CursoException(final String message, final Throwable cause,
      final boolean enableSuppression, final boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

  public CursoException(final String message, final Throwable cause) {
    super(message, cause);
  }

  public CursoException(final String message) {
    super(message);
  }

  public CursoException(final Throwable cause) {
    super(cause);
  }

  public int getCodigo() {
    return codigo;
  }

}
