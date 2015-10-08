package com.ipartek.formacion.bean.excepciones;

/**
 * <code>Exception</code> que sirve para tratar los errores de <code>Convocatoria</code>.
 *
 * @author Urko
 *
 */
public class ConvocatoriaException extends Exception {

  private static final long serialVersionUID = 1L;
  private transient int codigo;

  /**
   * Código de error al introducir un codigo en la convocatoria.
   * 
   */
  public static final int CODIGO_ERROR_CODIGO_INCORRECTO = 10;

  /**
   * Mensage de error al introducir un codigo de error en al convocatoria.
   */
  public static final String MSG_ERROR_CODIGO_CONVOCATORIA = "Código de error incorrecto";

  /**
   * Constructor que provee mensage de error y codigo de error.
   * 
   * @param mensage
   *          <code>String</code> mensage de error.
   * @param codigo
   *          <code>int</code> codigo de error.
   */
  public ConvocatoriaException(String mensage, final int codigo) {
    super(mensage);
    this.codigo = codigo;
  }

  /**
   * Constructor que provee mensage de error, la causa si debe de ser lanzada,y si se puede sacar la
   * traza.
   * 
   * @param message
   *          <code>String</code> es el mensaje.
   * @param cause
   *          <code>Throwable</code> es la causa.
   * @param enableSuppression
   *          <code>boolean</code> si se puede suprimir.
   * @param writableStackTrace
   *          <code>boolean</code> si se puede sacar la traza.
   */
  public ConvocatoriaException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

  /**
   * Constructor al que se le pasa la causa y el mensaje de la <code>ConvocatoriaException</code>.
   * 
   * @param message
   *          <code>String</code> es el mensaje.
   * @param cause
   *          <code>Throwable</code> es la causa.
   */
  public ConvocatoriaException(String message, Throwable cause) {
    super(message, cause);
  }

  /**
   * Constructor al que se le pasa el mensaje de la <code>ConvocatoriaException</code>.
   * 
   * @param message
   *          <code>String</code> es el mensaje.
   */
  public ConvocatoriaException(String message) {
    super(message);
  }

  /**
   * Constructor al que se le pasa la causa de la <code>ConvocatoriaException</code>.
   * 
   * @param cause
   *          <code>Throwable</code> es la causa.
   */
  public ConvocatoriaException(Throwable cause) {
    super(cause);
  }

  public int getCodigo() {
    return codigo;
  }

}
