package com.ipartek.formacion.bean;

import com.ipartek.formacion.bean.excepciones.ConvocatoriaException;

/**
 * Clase convocatorias.
 *
 * @author Administrador
 *
 */
public class Convocatoria {
  /**
   * Código invalido de una solicitud.
   */
  public static final int CODIGO_CONVOCATORIA = -1;

  private int codigo;
  private String nombre;
  private int codigoCurso;

  /**
   * Constructor en blanco de la clase <code>Convocatoria</code>.
   * 
   * @throws ConvocatoriaException
   *           en el caso de que el codigo sea negativo.
   */
  public Convocatoria() throws ConvocatoriaException {
    super();
    setCodigo(Convocatoria.CODIGO_CONVOCATORIA);
    setNombre("");
    setCodigoCurso(Curso.CODIGO_CURSO);
  }

  public int getCodigo() {
    return codigo;
  }

  /**
   * Cambia el codigo de la convocatoria.
   * 
   * @param codigo
   *          <code>int</code> el codigo de la convocatoria.
   * @throws ConvocatoriaException
   *           en el caso de que el código sea negativo.
   */
  public void setCodigo(int codigo) throws ConvocatoriaException {
    if (this.codigo >= Convocatoria.CODIGO_CONVOCATORIA) {
      this.codigo = codigo;
    } else {
      throw new ConvocatoriaException(ConvocatoriaException.MSG_ERROR_CODIGO_CONVOCATORIA,
          ConvocatoriaException.CODIGO_ERROR_CODIGO_INCORRECTO);
    }
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public int getCodigoCurso() {
    return codigoCurso;
  }

  public void setCodigoCurso(int codigoCurso) {
    this.codigoCurso = codigoCurso;
  }

}
