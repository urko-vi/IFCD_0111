package com.ipartek.formacion.service;

import com.ipartek.formacion.pojo.Convocatoria;
import com.ipartek.formacion.pojo.excepciones.ConvocatoriaException;
import com.ipartek.formacion.service.interfaces.IConvocatoriaService;

import java.util.ArrayList;
import java.util.List;

public class ConvocatoriaService implements IConvocatoriaService {
  List<Convocatoria> convocatorias = new ArrayList<Convocatoria>();

  public ConvocatoriaService() throws ConvocatoriaException {
    Convocatoria conv = new Convocatoria();
    convocatorias = new ArrayList<Convocatoria>();
    conv.setCodigo(1);
    conv.setNombre("primera convocatoria");
    conv.setDescripcion("Es la primera convocatoria");

    convocatorias.add(conv);

    conv = new Convocatoria();
    conv.setCodigo(2);
    conv.setNombre("segunda convocatoria");
    conv.setDescripcion("Es la segunda convocatoria");

    convocatorias.add(conv);
  }

  @Override
  public Convocatoria getById(int codigo) {
    // IConvocatoriaDAO cdao = ConvocatoriaDAO.getInstance(DAOFactory.MYSQL_CURSOS);
    boolean encontrado = false;
    int i = 0;
    Convocatoria conv = null;
    while (encontrado == false && i < convocatorias.size()) {
      if (convocatorias.get(i).getCodigo() == codigo) {
        encontrado = true;
        conv = convocatorias.get(i);
      }
      i++;
    }

    // Convocatoria conv = convocatorias.get(codigo);
    return conv;
  }

  @Override
  public List<Convocatoria> getAll() {

    return convocatorias;
  }
}
