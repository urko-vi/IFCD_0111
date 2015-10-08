package com.ipartek.formacion.service.interfaces;

import com.ipartek.formacion.bean.Convocatoria;
import com.ipartek.formacion.bean.excepciones.ConvocatoriaException;

import java.util.List;

/**
 * Interface que especifica los metodos de la logica de <code>Convocatoria</code>.
 *
 * @author Urko
 *
 */
public interface IConvocatoriaService {
  /**
   * Metodo para devolver la lista de convocatorias. Devuelve @return <code>List</code>
   * <code>Convocatoria</code>.
   */
  public List<Convocatoria> getAll();

  /**
   * Metodo para dar de alta <code>Convocatoria</code>.
   *
   * @param convocatoria
   *          <code>Convocatoria</code>.
   * @return <code>int</code> codigo de la <code>Convocatoria</code>.
   * @throws ConvocatoriaException
   *           en el caso de que el codigo sea negativo.
   */
  public int create(Convocatoria convocatoria) throws ConvocatoriaException;

  /**
   * Obtiene la convocatoria
   *
   * @param codigoConcovocatoria
   *          <code>int</code> codigo de la <code>Convocatoria</code>.
   * @return <code>Convocatoria</code>.
   */
  public Convocatoria getById(int codigoConvocatoria);

  /**
   * Actualiza los datos de la <code>Convocatoria</code>
   *
   * @param codigoConvocatoria
   *          <code>int</code> codigo de la <code>Convocatoria</code>.
   * @return <code>Convocatoria</code>.
   */
  public int update(Convocatoria convocatoria);

  /**
   * Borra una convocatoria dado su codigo.
   *
   * @param codigoConvocatoria
   *          <code>int</code>
   * @return <code>boolean</code>
   */
  public boolean delete(int codigoConvocatoria);

}
