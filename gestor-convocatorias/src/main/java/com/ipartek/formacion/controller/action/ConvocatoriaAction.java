package com.ipartek.formacion.controller.action;

import com.ipartek.formacion.controller.IActionController;
import com.ipartek.formacion.controller.View;
import com.ipartek.formacion.pojo.Convocatoria;
import com.ipartek.formacion.service.ConvocatoriaService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConvocatoriaAction implements IActionController {

  @Override
  public View execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    View vista = null;
    ConvocatoriaService cs = new ConvocatoriaService();
    List<Convocatoria> convocatorias = cs.getAll();
    Map<String, List<Convocatoria>> datos = new HashMap<String, List<Convocatoria>>();

    datos.put("datos", convocatorias);
    vista = new View("/backoffice/gestor-convocatoria.jsp");
    vista.setDatos(datos);
    return vista;
  }
}
