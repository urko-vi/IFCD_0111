/**
 * 
 */
package com.ipartek.formacion.service.interfaces;

import com.ipartek.formacion.pojo.Convocatoria;

import java.util.List;

/**
 * @author java
 *
 */
public interface IConvocatoriaService {

  public Convocatoria getById(int codigo);

  public List<Convocatoria> getAll();
}
