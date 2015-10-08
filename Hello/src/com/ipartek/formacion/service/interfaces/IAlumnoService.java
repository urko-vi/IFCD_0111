package com.ipartek.formacion.service.interfaces;

import com.ipartek.formacion.bean.Alumno;

import java.util.List;

public interface IAlumnoService {
  /**
   * Metodo para obtener los datos del <code>Alumno</code> con su id.
   * 
   * @param codigo
   *          <code>int</code> campo clave del <code>Alumno</code>.
   * @return <code>Alumno</code> solicitado.
   */
  public Alumno getById(final int codigo);

  /**
   * Obtener la <code>List</code> completa de <code>Alumno</code>.
   * 
   * @return <code>List</code> de <code>Alumno</code>
   */
  public List<Alumno> getAll();

  /**
   * Metodo que actualiza un <code>Alumno</code>
   * 
   * @param al
   *          <code>Alumno</code> es <code>Alumno</code> a actualizar.
   * @return <code>int</code> devuelve el codigo del <code>Alumno</code> actualizado -1 no se ha
   *         podido.
   */
  public int update(final Alumno al);

  /**
   * Metodo que elimina un <code>Alumno</code>.
   * 
   * @param codigo
   *          <code>int</code>
   * @return <code>boolean</code> true si la operación ha sido realizada con exito false si ha
   *         habido algun problema.
   */
  public boolean delete(final int codigo);

  /**
   * Metodo que inserta un nuevo <code>Alumno</code>.
   * 
   * @param al
   *          <code>Alumno</code> es <code>Alumno</code> a insertar.
   * @return <code>int</code> devuelve el codigo del <code>Alumno</code> insertado -1 no se ha
   *         podido.
   */
  public int create(final Alumno al);

}
