package com.ipartek.formacion.bean.excepciones;

/**
 * <code>Exception</code> que sirve para tratar los errores de <code>Convocatoria</code>.
 *
 * @author Urko
 *
 */
public class ConvocatoriaException extends Exception {

  private static final long serialVersionUID = 1L;

  /**
   *
   */
  public ConvocatoriaException() {
    super();
  }

  /**
   * 
   * @param message
   * @param cause
   * @param enableSuppression
   * @param writableStackTrace
   */
  public ConvocatoriaException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

  /**
   * 
   * @param message
   * @param cause
   */
  public ConvocatoriaException(String message, Throwable cause) {
    super(message, cause);
  }

  /**
   * 
   * @param message
   */
  public ConvocatoriaException(String message) {
    super(message);
  }

  /**
   * 
   * @param cause
   */
  public ConvocatoriaException(Throwable cause) {
    super(cause);
  }

}
