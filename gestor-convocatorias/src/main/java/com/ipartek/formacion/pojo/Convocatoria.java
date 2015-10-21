package com.ipartek.formacion.pojo;

import com.ipartek.formacion.pojo.excepciones.ConvocatoriaException;

import java.util.Set;

/**
 * Clase convocatorias.
 *
 * @author Administrador
 *
 */
public class Convocatoria {
  /**
   * C�digo invalido de una solicitud.
   */
  public static final int CODIGO_CONVOCATORIA = -1;

  private int codigo;
  private String nombre;
  private String descripcion;
  private Curso curso;
  private Set<Candidato> candidatos;

  // private int codigoCurso;

  public Set<Candidato> getCandidatos() {
    return candidatos;
  }

  public void setCandidatos(Set<Candidato> candidatos) {
    this.candidatos = candidatos;
  }

  public Curso getCurso() {
    return curso;
  }

  public void setCurso(Curso curso) {
    this.curso = curso;
  }

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
    setCurso(new Curso());
    // setCandidatos();
    // setCodigoCurso(Curso.CODIGO_CURSO);
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
   *           en el caso de que el c�digo sea negativo.
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

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

}
