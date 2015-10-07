package com.ipartek.formacion.bean;

/**
 * Clase convocatorias
 * 
 * @author Administrador
 *
 */
public class Convocatoria {
  /**
   * 
   */
  public static final int CODIGO_SOLICITUD = -1;
  private int codigo;

  private String nombre;

  private int codigoCurso;

  /**
   * Constructor en blanco de la classe <code>Convocatoria</code>
   */
  public Convocatoria() {
    super();
    setCodigo(Convocatoria.CODIGO_SOLICITUD);
    setNombre("");
    setCodigoCurso(Curso.CODIGO_CURSO);
  }

  public int getCodigo() {
    return codigo;
  }

  public void setCodigo(int codigo) {
    this.codigo = codigo;
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
