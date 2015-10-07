package com.ipartek.formacion.service;

import com.ipartek.formacion.bean.Convocatoria;
import com.ipartek.formacion.service.interfaces.IConvocatoriaService;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que implementa <code>IConvocatoriaService</code>.
 *
 * @author Urko
 *
 */
public class ConvocatoriaService implements IConvocatoriaService {
  private List<Convocatoria> convocatorias;
  private static int index;

  public ConvocatoriaService() {
    init();
  }

  private void init() {
    ConvocatoriaService.index = 0;
    convocatorias = new ArrayList<Convocatoria>();

  }

  /**
   * Metodo que devuelve toda la lista de convocatorias.
   *
   * @return <code>List</code>
   */
  @Override
  public List<Convocatoria> getAll() {
    return convocatorias;
  }

  /**
   * Metodo que crea una <code>Convocatoria</code>.
   *
   * @return <code>int</code> codigo de la <code>Convocatoria</code>.
   */
  @Override
  public int create(Convocatoria convocatoria) {
    int codigo = Convocatoria.CODIGO_CONVOCATORIA;
    convocatoria.setCodigo(ConvocatoriaService.index);

    if (convocatorias.add(convocatoria)) {
      ConvocatoriaService.index++;
      codigo = convocatoria.getCodigo();
    }
    return codigo;
  }

  /**
   * Obtener los datos de la <code>Convocatoria </code> a traves de su codigo.
   * 
   * @return <code>Convocatoria</code>.
   */
  @Override
  public Convocatoria getById(int codigoSolicitud) {
    Convocatoria convocatoria = null;

    return convocatoria;
  }

  @Override
  public int update(Convocatoria solicitud) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public boolean delete(int codigoSolicitud) {
    // TODO Auto-generated method stub
    return false;
  }

}
