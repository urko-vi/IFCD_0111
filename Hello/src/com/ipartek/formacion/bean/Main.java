package com.ipartek.formacion.bean;

import com.ipartek.formacion.bean.excepciones.ConvocatoriaException;
import com.ipartek.formacion.service.ConvocatoriaService;

public class Main {

  public static void main(String[] args) {
    int codigo = 0;

    ConvocatoriaService cs = new ConvocatoriaService();
    Convocatoria expected = cs.getById(codigo);
    expected = cs.getById(codigo);
    expected.setNombre("segunda convocatoria");
    try {
      expected.setCodigo(2);
    } catch (ConvocatoriaException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    cs.update(expected);
    Convocatoria actual = cs.getById(codigo);

  }
}
