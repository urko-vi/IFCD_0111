package com.ipartek.formacion.service;

import com.ipartek.formacion.bean.Convocatoria;
import com.ipartek.formacion.bean.excepciones.ConvocatoriaException;
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
    ConvocatoriaService.index = 1;
    convocatorias = new ArrayList<Convocatoria>();
    Convocatoria con = null;

    try {
      con = new Convocatoria();
      con.setCodigo(ConvocatoriaService.index);
      con.setNombre("Primera Convovatoria");
    } catch (ConvocatoriaException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    convocatorias.add(con);
    ConvocatoriaService.index++;
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
   * @throws ConvocatoriaException
   *           en el caso de que el codigo sea negativo.
   */
  @Override
  public int create(Convocatoria convocatoria) throws ConvocatoriaException {
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
   * @param codigoConvocatoria
   *          <code>int</code> codigo de la solicitud.
   * @return <code>Convocatoria</code>.
   */
  @Override
  public Convocatoria getById(int codigoConvocatoria) {
    Convocatoria convocatoria = null;
    int posicion = -1;

    posicion = obtenerPosicion(codigoConvocatoria);
    if (validarPosicion(posicion)) {
      convocatoria = convocatorias.get(posicion);
    }
    return convocatoria;
  }

  /**
   * Actualizar los datos de la <code>Convocatoria </code>.
   *
   * @param convocatoria
   *          <code>Convocatoria</code>.
   * @return <code>int</code>.
   */
  @Override
  public int update(Convocatoria convocatoria) {
    int posicion = -1;
    posicion = obtenerPosicion(convocatoria.getCodigo());
    if (validarPosicion(posicion)) {
      convocatorias.add(posicion, convocatoria);
    }

    return convocatoria.getCodigo();
  }

  private boolean validarPosicion(int posicion) {
    boolean valida = false;
    if (posicion > -1 && posicion < convocatorias.size()) {
      valida = true;
    }
    return valida;
  }

  /**
   * Borrar los datos de la <code>Convocatoria </code>.
   *
   * @param codigoConvocatoria
   *          <code>int</code> el codigo de la <code>Convocatoria</code>.
   * @return <code>boolean</code> <code>true</code>si todo fue bien <code>false</code> si todo va
   *         mal.
   */
  @Override
  public boolean delete(int codigoConvocatoria) {
    int posicion = -1;
    boolean borrado = false;
    posicion = obtenerPosicion(codigoConvocatoria);
    if (validarPosicion(posicion)) {
      convocatorias.remove(posicion);
      borrado = true;
    }

    return borrado;
  }

  private int obtenerPosicion(int codigo) {
    int pos = -1;
    int indice = 0;
    int lon = convocatorias.size();
    boolean encontrado = false;
    Convocatoria convocatoria = null;

    while (encontrado == false && indice < lon) {
      convocatoria = convocatorias.get(indice);
      if (codigo == convocatoria.getCodigo()) {
        encontrado = true;
        pos = indice;
      }
      indice++;
    }
    return pos;
  }
}
