package com.ipartek.formacion.bean;

import com.ipartek.formacion.bean.excepciones.CursoException;
import com.ipartek.formacion.util.TipoCurso;

import java.util.HashMap;
import java.util.Map;

/**
 * Es la clase que agrupa los datos de un <code>Curso</code>.
 *
 * @author Administrador
 *
 */
public class Curso {

  /**
   * {@code int} c�digo de curso minimo.
   */
  public static final int CODIGO_CURSO = -1;
  /**
   * {@code double} precio minimo del curso.
   */
  public static final double PRECIO_CURSO = 0.0;

  /**
   * {@code int} codigo el c�digo del curso.
   */
  private int codigo;
  /**
   * {@code String} nombre es el nombre del curso.
   */
  private String nombre;
  /**
   * {@code Map<Integer,Alumno>} es listado de alumnos matriculados al curso.
   */
  private Map<Integer, Alumno> listadoAlumnos;
  /**
   * {@code TipoCurso} es tipo de curso.
   */
  private TipoCurso tipoCurso;
  /**
   * {@code double} es precio del curso.
   */
  private double precio;

  /**
   * El constructor en blanco de la clase {@code Curso}
   *
   * @throws CursoException
   *           en el caso de que el precio sea negativo y el codigo negativo.
   */
  public Curso() throws CursoException {
    super();
    setCodigo(0);
    setNombre("");
    setListadoAlumnos(new HashMap<Integer, Alumno>());
  }

  public double getPrecio() {
    return precio;
  }

  /**
   * Metodo para fijar el precio.
   * 
   * @param precio
   *          <code>double</code> es lo que cuesta.
   *
   * @throws CursoException
   *           en el caso de que el precio sea negativo.
   */
  public void setPrecio(double precio) throws CursoException {
    if (precio >= Curso.PRECIO_CURSO) {
      this.precio = precio;
    } else {
      throw new CursoException(CursoException.MSG_ERROR_PRECIO, CursoException.COD_ERROR_PRECIO);
    }
  }

  public TipoCurso getTipoCurso() {
    return tipoCurso;
  }

  public void setTipoCurso(TipoCurso tipoCurso) {
    this.tipoCurso = tipoCurso;
  }

  public int getCodigo() {
    return codigo;
  }

  /**
   * 
   * @param codigo
   *          <code>int</code> el codigo del <code>Curso</code>.
   * @throws CursoException
   *           en el caso de que el valor sea negativo.
   */
  public void setCodigo(int codigo) throws CursoException {
    if (codigo > Curso.CODIGO_CURSO) {
      this.codigo = codigo;
    } else {
      throw new CursoException(CursoException.MSG_ERROR_CODIGO, CursoException.COD_ERROR_CURSO);
    }
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public Map<Integer, Alumno> getListadoAlumnos() {
    return listadoAlumnos;
  }

  public void setListadoAlumnos(Map<Integer, Alumno> listadoAlumnos2) {
    listadoAlumnos = listadoAlumnos2;
  }

}
